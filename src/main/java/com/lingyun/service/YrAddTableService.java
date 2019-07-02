package com.lingyun.service;

import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.entity.YrAddTableConditionEntity;
import com.lingyun.domain.entity.YrAddTableEntity;
import com.lingyun.domain.entity.YrAddTableRowEntity;

/**
 * <p>
 * 新建空表
 * <p/>
 *
 * @author liujie
 * @email " "
 * @date 2019-01-22 14:31:25
 */
public interface YrAddTableService extends IService<YrAddTableEntity> {

    /**
     * 添加新增表
     * @param entity
     * @return
     */
    Integer addNewTable(YrAddTableEntity entity);

    /**
     * 添加新增表 列信息
     * @param rowEntity
     * @return
     */
    Integer addTableRow(YrAddTableRowEntity rowEntity);

    /**
     * 添加条件
     * @param entity
     * @return
     */
    Integer addTableCondition(YrAddTableConditionEntity entity);

    /**
     * 表数据填充
     * @param tableId
     * @return
     */
    Integer tableDataFill(Integer tableId);
}

