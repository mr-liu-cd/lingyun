package com.lingyun.service.impl;

import com.lingyun.dao.LyCarDao;
import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.domain.from.LyCarTypeFrom;
import com.lingyun.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;

import com.lingyun.dao.LyCarTypeDao;
import com.lingyun.domain.entity.LyCarTypeEntity;
import com.lingyun.service.LyCarTypeService;


@Service("lyCarTypeService")
public class LyCarTypeServiceImpl extends ServiceImpl<LyCarTypeDao, LyCarTypeEntity> implements LyCarTypeService {

    @Autowired
    private LyCarTypeDao carTypeDao;

    @Autowired
    private LyCarDao carDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyCarTypeEntity> page = this.selectPage(
                new Query<LyCarTypeEntity>(params).getPage(),
                new EntityWrapper<LyCarTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getCarTypeList(Page<LyCarTypeFrom > page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(carTypeDao.getCarTypeList(map));
        page.setTotal(carTypeDao.countCarTypeList(map));
        return new PageUtils(page);
    }

    @Override
    public Integer addCarType(LyCarTypeEntity entity) {
        if(entity.getBrandId()==null){
            throw new ObjectException(306,"品牌不能为空");
        }
        carTypeDao.insert(entity);
        return null;
    }

    @Override
    public Integer updateCartType(LyCarTypeEntity entity) {
        Integer id = entity.getId();
        if(id==null){
            throw new ObjectException(306,"系统异常");
        }
        carTypeDao.updateById(entity);
        return null;
    }

    @Override
    public Integer delCarType(Integer carTypeId) {
        //根据id获取使用的car
        List<LyCarEntity> list = carDao.selectList(new EntityWrapper<LyCarEntity>().eq("car_type", carTypeId));
        if(list==null||list.size()<1){
            carTypeDao.deleteById(carTypeId);
        }else{
            throw new ObjectException(305,"车型使用中，不能删除");
        }
        return null;
    }

    @Override
    public List<LyCarTypeEntity> getCarTypeByBrand(Integer brandId) {
        return  carTypeDao.selectList(new EntityWrapper<LyCarTypeEntity>().eq("brand_id", brandId));
    }

}
