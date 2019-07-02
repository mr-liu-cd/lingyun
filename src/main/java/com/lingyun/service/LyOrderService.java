package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.domain.from.LyOrderDetailFrom;
import com.lingyun.domain.from.LyOrderFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * <p/>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
public interface LyOrderService extends IService<LyOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LyOrderFrom> getOrderByCar(Integer id);

    List<LyOrderFrom> getOrderByCustomer(Integer id);

    Integer addOrder(LyOrderDto orderDto);

    Integer addOrderDetail(Integer orderId, Integer unitDetailId, Integer num, Double price);

    Integer updateOrderDetail(LyOrderDetailEntity entity);

    Integer delOrderDetail(Integer id);

    PageUtils getOrderDetailByOrder(Page<LyOrderDetailFrom> page);

    PageUtils getOrderList(Page<LyOrderFrom> page);
}

