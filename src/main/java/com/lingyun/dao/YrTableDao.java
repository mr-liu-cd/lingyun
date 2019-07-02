package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.YrTableEntity;
import com.lingyun.domain.entity.YrTableRowEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujie
 * @email " "
 * @date 2018-12-27 16:26:54
 */
public interface YrTableDao extends BaseMapper<YrTableEntity> {

    /**
     * 获取表列表
     * @param map
     * @return
     */
    List<YrTableEntity> getTableList(Map<String, Object> map);

    Integer countTableList(Map<String, Object> map);

    /**
     * 获取所有列
     * @param tableId
     * @return
     */
    List<YrTableRowEntity> getRowList(Integer tableId);
}
