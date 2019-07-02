package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.*;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.domain.entity.LyCustomerEntity;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.domain.entity.LyOrderEntity;
import com.lingyun.domain.from.LyOrderDetailFrom;
import com.lingyun.domain.from.LyOrderFrom;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.LyOrderService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service("lyOrderService")
public class LyOrderServiceImpl extends ServiceImpl<LyOrderDao, LyOrderEntity> implements LyOrderService {

    @Autowired
    private LyOrderDao orderDao;
    @Autowired
    private LyCustomerDao customerDao;
    @Autowired
    private LyCarDao carDao;
    @Autowired
    private LyUnitDetailDao detailDao;

    @Autowired
    private LyOrderDetailDao orderDetailDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyOrderEntity> page = this.selectPage(
                new Query<LyOrderEntity>(params).getPage(),
                new EntityWrapper<LyOrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LyOrderFrom> getOrderByCar(Integer id) {
        return orderDao.getOrderByCar(id);
    }

    @Override
    public List<LyOrderFrom> getOrderByCustomer(Integer id) {
        return orderDao.getOrderByCustomer(id);
    }

    @Override
    public Integer addOrder(LyOrderDto orderDto) {
        LyOrderEntity orderEntity = new LyOrderEntity();
        Integer carId = orderDto.getCarId();
        Integer customerId = orderDto.getCustomerId();
        if(customerId==null||carId==null){
            LyCustomerEntity entity = new LyCustomerEntity();
            if(StringUtils.isBlank(orderDto.getIdCard())){
                throw new ObjectException(306,"请填写证件号信息");
            }
            if(StringUtils.isBlank(orderDto.getName())){
                throw new ObjectException(306,"请填写客户姓名");
            }
            if(StringUtils.isBlank(orderDto.getTele())){
                throw new ObjectException(306,"请填写客户联系方式");
            }
            entity.setIdCard(orderDto.getIdCard());
            entity.setName(orderDto.getName());
            entity.setTele(orderDto.getTele());
            entity.setRepairTimes(1);
            customerDao.insert(entity);
            customerId=entity.getId();


            LyCarEntity carEntity = new LyCarEntity();
            if(StringUtils.isBlank(orderDto.getLicense())){
                throw new ObjectException(306,"请填写车牌号");
            }
            if(orderDto.getCarType()==null){
                throw new ObjectException(306,"请选择车型号");
            }
            if(orderDto.getAnnualInspectionTime()==null||orderDto.getInsuranceTime()==null){
                throw new ObjectException(306,"请选择年检以及保险日期");
            }
            carEntity.setCarType(orderDto.getCarType());
            carEntity.setAnnualInspectionTime(orderDto.getAnnualInspectionTime());
            carEntity.setInsuranceTime(orderDto.getInsuranceTime());
            carEntity.setLicense(orderDto.getLicense());
            carEntity.setCustomerId(customerId);
            carDao.insert(carEntity);
            carId=carEntity.getId();
        }else{
            LyCustomerEntity customer = customerDao.selectById(customerId);
            if(customer==null){
                throw new ObjectException(306,"参数异常，请重新录入");
            }
            customer.setRepairTimes(customer.getRepairTimes()+1);
            customerDao.updateById(customer);
            LyCarEntity car = carDao.selectById(carId);
            if(car==null){
                throw new ObjectException(306,"参数异常，请重新录入");
            }
            car.setRecentRepairTime(new Date());
            carDao.updateById(car);
        }
        orderEntity.setCarId(carId);
        orderEntity.setPayTotal(new BigDecimal(0));
        orderEntity.setCustomerId(customerId);
        orderEntity.setState(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(new Date());
        orderEntity.setOrderNum(str+new Random().nextInt(9));
        orderDao.insert(orderEntity);
        return null;
    }

    @Override
    public Integer addOrderDetail(Integer orderId, Integer unitDetailId, Integer num, Double price) {
        LyOrderEntity order = orderDao.selectById(orderId);
        if(order==null){
            throw new ObjectException(306,"没有该订单，明细添加失败");
        }
        BigDecimal total = order.getPayTotal();
        if(total==null){
            total=new BigDecimal(0);
        }
        LyOrderDetailEntity detail = new LyOrderDetailEntity();
        detail.setOrderId(orderId);
        detail.setNum(num);
        detail.setPrice(new BigDecimal(price));
        detail.setDetailId(unitDetailId);
        orderDetailDao.insert(detail);
        total = total.add(new BigDecimal(num * price));
        order.setPayTotal(total);
        orderDao.updateById(order);
        return null;
    }

    @Override
    public Integer updateOrderDetail(LyOrderDetailEntity entity) {
        if(entity.getDetailId()==null||entity.getNum()==null||entity.getPrice()==null||entity.getOrderId()==null){
            throw new ObjectException(309,"参数不足");
        }
        LyOrderEntity orderEntity = orderDao.selectById(entity.getOrderId());
        LyOrderDetailEntity detailEntity = orderDetailDao.selectById(entity.getId());
        BigDecimal payTotal = orderEntity.getPayTotal();
        payTotal=payTotal.subtract(detailEntity.getPrice().multiply(new BigDecimal(detailEntity.getNum())));
        payTotal=payTotal.add(entity.getPrice().multiply(new BigDecimal(entity.getNum())));
        orderDetailDao.updateById(entity);
        orderEntity.setPayTotal(payTotal);
        orderDao.updateById(orderEntity);
        return null;
    }

    @Override
    public Integer delOrderDetail(Integer id) {
        LyOrderDetailEntity detail = orderDetailDao.selectById(id);
        if(detail==null){
            throw new ObjectException(305,"参数异常");
        }
        LyOrderEntity lyOrderEntity = orderDao.selectById(detail.getOrderId());
        lyOrderEntity.setPayTotal(lyOrderEntity.getPayTotal().subtract(detail.getPrice().multiply(new BigDecimal(detail.getNum()))));
        orderDao.updateById(lyOrderEntity);
        orderDetailDao.deleteById(id);
        return null;
    }

    @Override
    public PageUtils getOrderDetailByOrder(Page<LyOrderDetailFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(orderDetailDao.getOrderDetailByOrder(map));
        page.setTotal(orderDetailDao.countOrderDetailByOrder(map));
        return new PageUtils(page);
    }

    @Override
    public PageUtils getOrderList(Page<LyOrderFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(orderDao.getOrderList(map));
        page.setTotal(orderDao.countOrderList(map));
        return new PageUtils(page);
    }

}
