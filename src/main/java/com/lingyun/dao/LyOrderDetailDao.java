package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.domain.from.LyOrderDetailFrom;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
public interface LyOrderDetailDao extends BaseMapper<LyOrderDetailEntity> {

    List<LyOrderDetailFrom> getOrderDetailByOrder(Map<String, Object> map);

    Integer countOrderDetailByOrder(Map<String, Object> map);
}
