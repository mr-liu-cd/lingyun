package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.dto.YrTableRowDTO;
import com.lingyun.domain.dto.YrTableValDTO;
import com.lingyun.domain.entity.YrTableValEntity;

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
public interface YrTableValDao extends BaseMapper<YrTableValEntity> {

    /**
     * 批量添加数据
     * @param valList
     * @return
     */
    Integer batchInsert(List<YrTableValEntity> valList);

    /**
     * 获取表 当前行
     * @param tableId
     * @return
     */
    Integer getCurrentLine(Integer tableId);

    /**
     * 删除行
     * @param map
     * @return
     */
    Integer deleteRow(Map<String, Integer> map);

    /**
     * 根据表以及行获取所有参数
     * @param map
     * @return
     */
    List<YrTableValDTO> getValListByLine(Map<String, Object> map);

    List<YrTableRowDTO> getTableList(Map<String,Object> map);

    Integer countTableList(Map<String, Object> map);

    Integer deleteTable(Integer tableId);
}
