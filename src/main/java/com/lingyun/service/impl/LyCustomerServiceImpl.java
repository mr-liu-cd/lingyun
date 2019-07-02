package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.LyCarDao;
import com.lingyun.dao.LyCustomerDao;
import com.lingyun.dao.LyOrderDao;
import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.domain.entity.LyCustomerEntity;
import com.lingyun.domain.from.LyCustomerFrom;
import com.lingyun.domain.from.LyOrderFrom;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.LyCustomerService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("lyCustomerService")
public class LyCustomerServiceImpl extends ServiceImpl<LyCustomerDao, LyCustomerEntity> implements LyCustomerService {

    @Autowired
    private LyCustomerDao customerDao;
    @Autowired
    private LyOrderDao orderDao;

    @Autowired
    private LyCarDao carDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyCustomerEntity> page = this.selectPage(
                new Query<LyCustomerEntity>(params).getPage(),
                new EntityWrapper<LyCustomerEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getCustomerList(Page<LyCustomerFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(customerDao.getCustomerList(map));
        page.setTotal(customerDao.countCustomerList(map));
        return new PageUtils(page);
    }

    @Override
    public Integer delCustomer(Integer id) {
        List<LyOrderFrom> list = orderDao.getOrderByCustomer(id);
        if(list!=null&&list.size()>0){
            throw new ObjectException(406,"该用户有订单产生，不能删除");
        }
        List<LyCarEntity> customerList = carDao.selectList(new EntityWrapper<LyCarEntity>().eq("customer_id", id));
        if(customerList!=null&&customerList.size()>0){
            throw new ObjectException(406,"请先删除该客户汽车，再删除用户");
        }
        customerDao.deleteById(id);
        return null;
    }

    @Override
    public List<LyCustomerEntity> getAllCustomer(String key) {
        EntityWrapper<LyCustomerEntity> wrapper = new EntityWrapper<>();
        if(StringUtils.isNotBlank(key)){
            wrapper.like("name","%"+key+"%");
        }
        return customerDao.selectList(wrapper);
    }

}
