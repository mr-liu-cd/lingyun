package com.lingyun.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.YrTableRowDao;
import com.lingyun.dao.YrTableValDao;
import com.lingyun.domain.dto.YrTableRowDTO;
import com.lingyun.domain.entity.YrTableRowEntity;
import com.lingyun.service.YrTableRowService;
import com.lingyun.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("yrTableRowService")
public class YrTableRowServiceImpl extends ServiceImpl<YrTableRowDao, YrTableRowEntity> implements YrTableRowService {

    @Autowired
    private YrTableRowDao rowDao;
    @Autowired
    private YrTableValDao valDao;

    @Override
    public PageUtils getTableDetail(Page<YrTableRowDTO> page) {
        Map<String, Object> map = PageUtils.getParamMap(page);
        List<YrTableRowDTO> dataList=new ArrayList<>();
        YrTableRowDTO dto = new YrTableRowDTO();
        //获取头
        List<String> head = rowDao.getHeardList(map);
        dto.setHeaders(head);
        //获取值
        List<Map> data=new ArrayList<>();
        List<YrTableRowDTO> list = valDao.getTableList(map);
        for (YrTableRowDTO rowDTO : list) {
            String str = rowDTO.getVal();
            if(StringUtils.isNotBlank(str)){
                String[] split = str.split(",");
                Map dataMap=new HashMap();
                for (int i = 0; i < split.length; i++) {
                    String string = split[i];
                    String[] kv = string.split(":");
                    dataMap.put(kv[0],kv[1]);
                }
                dataMap.put("$序号",rowDTO.getLine());
                data.add(dataMap);
            }
        }
        dto.setData(data);
        dataList.add(dto);
        page.setRecords(dataList);
        page.setTotal(valDao.countTableList(map));
        return new PageUtils(page);
    }
}
