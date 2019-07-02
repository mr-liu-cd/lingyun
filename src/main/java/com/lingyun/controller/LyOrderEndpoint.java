package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.domain.from.LyOrderDetailFrom;
import com.lingyun.domain.from.LyOrderFrom;
import com.lingyun.service.LyOrderService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@Api("接口文档")
@RestController
@RequestMapping("lingyun/order")
public class LyOrderEndpoint {
    @Autowired
    private LyOrderService lyOrderService;

    @ApiOperation(value = "根据车查询相关订单")
    @GetMapping("/get_order_by_car")
    public Response getOrderByCar(@RequestParam Integer id){
        return Response.ok().put("data",lyOrderService.getOrderByCar(id));
    }

    @ApiOperation(value = "根据用户查询相关订单")
    @GetMapping("/get_order_by_customer")
    public Response getOrderByCustomer(@RequestParam Integer id){
        return Response.ok().put("data",lyOrderService.getOrderByCustomer(id));
    }

    @ApiOperation(value = "添加订单")
    @PostMapping
    public Response addOrder(@RequestBody LyOrderDto orderDto){
        lyOrderService.addOrder(orderDto);
        return  Response.ok();
    }

    @ApiOperation(value = "订单添加明细")
    @PostMapping("/add_order_detail")
    public Response addOrderDetail(@RequestParam Integer orderId,@RequestParam Integer unitDetailId,@RequestParam Double price,@RequestParam Integer num){
        lyOrderService.addOrderDetail(orderId,unitDetailId,num,price);
        return Response.ok();
    }

    @ApiOperation(value = "订单明细修改")
    @PutMapping("/update_order_detail")
    public Response updateOrderDetail(@RequestBody LyOrderDetailEntity entity){
        lyOrderService.updateOrderDetail(entity);
        return Response.ok();
    }

    @ApiOperation(value = "订单明细删除")
    @DeleteMapping("/del_order_detail")
    public Response delOrderDetail(@RequestParam Integer id){
        lyOrderService.delOrderDetail(id);
        return Response.ok();
    }

    @ApiOperation(value = "根据订单查询明细")
    @GetMapping("/get_order_detail_by_order")
    public Response getOrderDetailByOrder(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam Integer orderId){
        Map map=new HashMap();
        map.put("orderId",orderId);
        Page<LyOrderDetailFrom> page = new Page<>(pageNum,pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyOrderService.getOrderDetailByOrder(page));
    }

    @ApiOperation(value = "获取订单列表")
    @GetMapping("/list")
    public Response getOrderList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,String key,String start,String end){
        Map map=new HashMap();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        if(StringUtils.isNotBlank(start)){
            map.put("start",start);
        }
        if(StringUtils.isNotBlank(end)){
            map.put("end",end);
        }
        Page<LyOrderFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyOrderService.getOrderList(page));
    }

}
