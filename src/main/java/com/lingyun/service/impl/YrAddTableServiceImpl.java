package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.*;
import com.lingyun.domain.entity.*;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.YrAddTableService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("yrAddTableService")
public class YrAddTableServiceImpl extends ServiceImpl<YrAddTableDao, YrAddTableEntity> implements YrAddTableService {

    @Autowired
    private YrAddTableDao addTableDao;
    @Autowired
    private YrAddTableRowDao addTableRowDao;
    @Autowired
    private YrAddTableConditionDao conditionDao;
    @Autowired
    private YrTableDao tableDao;
    @Autowired
    private YrTableRowDao rowDao;
    @Autowired
    private YrTableValDao valDao;

    @Override
    public Integer addNewTable(YrAddTableEntity entity) {
        String tableName = entity.getTableName();
        if (StringUtils.isBlank(tableName)) {
            throw new ObjectException(305, "表名不能为空");
        }
        addTableDao.insert(entity);
        return null;
    }

    @Override
    public Integer addTableRow(YrAddTableRowEntity rowEntity) {
        if (rowEntity.getRowId() == null || rowEntity.getTableId() == null) {
            throw new ObjectException(305, "参数异常");
        }
        rowEntity.setStatus(1);
        addTableRowDao.insert(rowEntity);
        return null;
    }

    @Override
    public Integer addTableCondition(YrAddTableConditionEntity entity) {
        if (entity.getRowEndId() == null || entity.getRowPreId() == null || entity.getTableId() == null) {
            throw new ObjectException(305, "参数异常");
        }
        conditionDao.insert(entity);
        // TODO: 2019/1/22
        YrAddTableRowEntity yrAddTableRowEntity = addTableRowDao.selectById(entity.getRowEndId());
        yrAddTableRowEntity.setStatus(2);
        addTableRowDao.updateById(yrAddTableRowEntity);
        return null;
    }

    @Override
    @Transactional
    public Integer tableDataFill(Integer tableId) {
        Map<Integer, Integer> map = new HashMap();
        YrAddTableEntity tableEntity = addTableDao.selectById(tableId);
        if (tableEntity == null) {
            throw new ObjectException(305, "参数异常");
        }
        //添加表名
        YrTableEntity entity = new YrTableEntity(tableEntity.getTableName());
        tableDao.insert(entity);
        Integer id = entity.getId();
        //添加列
        addRow(tableId, map, id);
        //添加值
        //1.添加无状态的
        addNoStatusRowValue(tableId, map);
        //2.添加有条件的
        List<YrAddTableConditionEntity> conditionList = conditionDao.selectList(new EntityWrapper<YrAddTableConditionEntity>().eq("table_id", tableId));
        if(conditionList!=null&&conditionList.size()>1){
            for (int i = 0; i < conditionList.size(); i++) {
                YrAddTableConditionEntity condition = conditionList.get(i);
                //条件
                Integer rowPreId = condition.getRowPreId();
                //结果
                Integer rowEndId = condition.getRowEndId();
                //根据oldRowId获取值列表
                List<YrTableValEntity> list = valDao.selectList(new EntityWrapper<YrTableValEntity>().eq("row_id", rowEndId));
                Map<String,Integer> valMap=new HashMap();
                for (YrTableValEntity yrTableValEntity : list) {
                    valMap.put(yrTableValEntity.getVal(),yrTableValEntity.getLine());
                }
                //获取已添加，条件列ID
                Integer rowId = map.get(rowPreId);
                //根据oldRowId获取值列表
                List<YrTableValEntity> valList = valDao.selectList(new EntityWrapper<YrTableValEntity>().eq("row_id", rowId));
                for (YrTableValEntity yrTableValEntity : valList) {
                    //循环判断，如果有值相同的则添加数据
                    Integer line = valMap.get(yrTableValEntity.getVal());
                    if (line!=null){
                        //添加当前列
                        YrTableValEntity valEntity = new YrTableValEntity();
                        valEntity.setVal(yrTableValEntity.getVal());
                        valEntity.setLine(line);
                        valEntity.setRowId(map.get(rowEndId));
                        valDao.insert(valEntity);
                        //添加当前列所属表
                        // TODO: 2019/1/22  
                        addTableRowDao.getOtherRowList(tableId);

                    }
                }

            }
        }


        return null;
    }

    private void addRow(Integer tableId, Map<Integer, Integer> map, Integer id) {
        List<YrAddTableRowEntity> rowList = addTableRowDao.selectList(new EntityWrapper<YrAddTableRowEntity>().eq("table_id", tableId));
        if (rowList != null && rowList.size() > 1) {
            for (YrAddTableRowEntity yrAddTableRowEntity : rowList) {
                Integer rowId = yrAddTableRowEntity.getRowId();
                YrTableRowEntity row = rowDao.selectById(rowId);
                YrTableRowEntity yrTableRowEntity = new YrTableRowEntity(row.getName(), id);
                rowDao.insert(yrTableRowEntity);
                map.put(rowId, yrTableRowEntity.getId());
            }
        }
    }

    private void addNoStatusRowValue(Integer tableId, Map<Integer, Integer> map) {
        List<YrTableValEntity> valList = new ArrayList<>();
        List<YrAddTableRowEntity> noStatusRow = addTableRowDao.getNoStatusRow(tableId);
        for (YrAddTableRowEntity yrAddTableRowEntity : noStatusRow) {
            Integer addRowId = yrAddTableRowEntity.getId();
            Integer oldRowId = yrAddTableRowEntity.getRowId();
            Integer rowId = map.get(addRowId);
            //根据oldRowId获取值列表
            List<YrTableValEntity> list = valDao.selectList(new EntityWrapper<YrTableValEntity>().eq("row_id", oldRowId));
            if (list != null && list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    YrTableValEntity yrTableValEntity = list.get(i);
                    YrTableValEntity valEntity = new YrTableValEntity();
                    valEntity.setLine(yrTableValEntity.getLine());
                    valEntity.setRowId(rowId);
                    valEntity.setVal(yrTableValEntity.getVal());
                    valList.add(valEntity);
                    if (i == list.size() - 1 || valList.size() == 100) {
                        valList.clear();
                        valDao.batchInsert(valList);
                    }
                }
            }

        }
    }
}
