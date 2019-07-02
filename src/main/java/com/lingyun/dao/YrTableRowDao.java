package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface YrTableRowDao extends BaseMapper<YrTableRowEntity> {

    /**
     * 根据表名获取所有头信息
     * @param map
     * @return
     */
    List<String> getHeardList(Map<String, Object> map);
}
