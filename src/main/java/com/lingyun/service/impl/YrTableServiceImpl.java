package com.lingyun.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.YrTableDao;
import com.lingyun.dao.YrTableRowDao;
import com.lingyun.dao.YrTableValDao;
import com.lingyun.domain.dto.YrTableValDTO;
import com.lingyun.domain.entity.YrTableEntity;
import com.lingyun.domain.entity.YrTableRowEntity;
import com.lingyun.domain.entity.YrTableValEntity;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.YrTableService;
import com.lingyun.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("yrTableService")
public class YrTableServiceImpl extends ServiceImpl<YrTableDao, YrTableEntity> implements YrTableService {

    @Autowired
    private YrTableDao tableDao;
    @Autowired
    private YrTableRowDao rowDao;
    @Autowired
    private YrTableValDao valDao;

    @Override
    @Transactional
    public Integer excelUpload(String name, MultipartFile file) {

        YrTableEntity entity = new YrTableEntity();
        entity.setTableName(name);
        tableDao.insert(entity);
        Integer id = entity.getId();
        InputStream inputStream=null;
        try {
            InputStream ins = file.getInputStream();
            File  f=new File(file.getOriginalFilename());
            inputStreamToFile(ins, f);
            inputStream=new BufferedInputStream(new FileInputStream(f));
            List<Object> list = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
            handleExcel(id,list);
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
           throw new ObjectException(305,"上传异常"+e.getMessage());
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    @Override
    public PageUtils getTableList(Page<YrTableEntity> page) {
        Map<String, Object> map = PageUtils.getParamMap(page);
        page.setRecords(tableDao.getTableList(map));
        page.setTotal(tableDao.countTableList(map));
        return new PageUtils(page);
    }

    @Override
    @Transactional
    public Integer addTableRow(Integer tableId, Map map) {
        if (tableId==null){
            throw new ObjectException(305,"参数异常");
        }
        //获取当前行数
        Integer currentLine = valDao.getCurrentLine(tableId);
        //获取所有列
        List<YrTableRowEntity> rowList = tableDao.getRowList(tableId);
        for (int i = 0; i < rowList.size(); i++) {
            YrTableRowEntity rowEntity = rowList.get(i);
            Object o = map.get(rowEntity.getName());
            YrTableValEntity valEntity = new YrTableValEntity();
           if(StringUtils.isNotBlank(String.valueOf(o))){
               valEntity.setVal(String.valueOf(o));
               valEntity.setRowId(rowEntity.getId());
               valEntity.setLine(currentLine+1);
               valDao.insert(valEntity);
           }
        }
        return null;
    }

    @Override
    @Transactional
    public Integer deleteRow(Integer tableId, Integer line) {
        Map<String,Integer> map=new HashMap<>();
        map.put("tableId",tableId);
        map.put("line",line);
        return valDao.deleteRow(map);
    }

    @Override
    @Transactional
    public Integer updateTableVal(Integer tableId, Map map, Integer line) {
        if(tableId==null||line==null){
            throw new ObjectException(305,"参数异常");
        }
        Map param=new HashMap();
        param.put("tableId",tableId);
        param.put("line",line);
        //获取所有列
        List<YrTableValDTO> valList = valDao.getValListByLine(param);
        if(valList!=null&&valList.size()>0){
            for (YrTableValDTO yrTableValDTO : valList) {
                YrTableValEntity entity = new YrTableValEntity();
                BeanUtils.copyProperties(yrTableValDTO,entity);
                String rowName = yrTableValDTO.getRowName();
                Object o = map.get(rowName);
                entity.setVal(String.valueOf(o));
                valDao.updateById(entity);
            }
        }
        return null;
    }

    @Override
    public Integer deleteTable(Integer tableId) {
        valDao.deleteTable(tableId);
        return null;
    }

    private void handleExcel(Integer id,List<Object> list) {
        if(list==null||list.size()<1){
            return;
        }
        List<YrTableValEntity> valList=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            if(o instanceof List){
                List<String> line = (List) o;
                if(line!=null&&line.size()>0){
                    Integer res = i == 0 ? handleHeader(id, map, line) : handleValue(valList, map, i, line);
                }
                //处理批量数据
                if(valList.size()>=500||i==list.size()-1){
                    valDao.batchInsert(valList);
                }
            }
        }
    }

    private Integer handleValue(List<YrTableValEntity> valList, Map<Integer, Integer> map, int i, List<String> line) {
        for (int j = 0; j < line.size(); j++) {
            Integer rowId = map.get(j);
            if(rowId!=null){
                YrTableValEntity valEntity = new YrTableValEntity();
                valEntity.setLine(i);
                valEntity.setRowId(rowId);
                valEntity.setVal(line.get(j));
                valList.add(valEntity);
            }
        }
        return null;
    }

    private Integer handleHeader(Integer id, Map<Integer, Integer> map, List<String> line) {
        for (int j = 0; j < line.size(); j++) {
            YrTableRowEntity rowEntity = new YrTableRowEntity();
            rowEntity.setName(line.get(j));
            rowEntity.setTableId(id);
            rowDao.insert(rowEntity);
            Integer rowId = rowEntity.getId();
            map.put(j,rowId);
        }
        return null;
    }

}
