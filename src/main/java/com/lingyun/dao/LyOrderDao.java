package com.lingyun.dao;

import com.lingyun.domain.entity.LyOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.from.LyOrderFrom;

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
public interface LyOrderDao extends BaseMapper<LyOrderEntity> {

    List<LyOrderFrom> getOrderByCar(Integer id);

    List<LyOrderFrom> getOrderByCustomer(Integer id);

    List<LyOrderFrom> getOrderList(Map<String, Object> map);

    Integer countOrderList(Map<String, Object> map);
}
