package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.YrAddTableRowEntity;

import java.util.List;

/**
 * <p>
 * 添加表 列属性
 * </p>
 *
 * @author liujie
 * @email " "
 * @date 2019-01-22 14:31:25
 */
public interface YrAddTableRowDao extends BaseMapper<YrAddTableRowEntity> {

    /**
     * 获取无状态的列 列表
     * @param tableId
     * @return
     */
    List<YrAddTableRowEntity> getNoStatusRow(Integer tableId);

    /**
     * 获取相同表内的其他列 信息
     * @param rowEndId
     * @return
     */
    List<YrAddTableRowEntity> getOtherRowList(Integer rowEndId);
}
