package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.config.Constants;
import com.lingyun.dao.LyCarTypeDao;
import com.lingyun.dao.LyOrderDetailDao;
import com.lingyun.dao.LyUnitDetailDao;
import com.lingyun.dao.LyUnitsDao;
import com.lingyun.domain.entity.LyCarTypeEntity;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.lingyun.domain.entity.LyUnitsEntity;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.LyUnitDetailService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("lyUnitDetailService")
public class LyUnitDetailServiceImpl extends ServiceImpl<LyUnitDetailDao, LyUnitDetailEntity> implements LyUnitDetailService {

    @Autowired
    private LyUnitsDao unitsDao;

    @Autowired
    private LyUnitDetailDao detailDao;
    @Autowired
    private LyOrderDetailDao orderDetailDao;
    @Autowired
    private LyCarTypeDao carTypeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyUnitDetailEntity> page = this.selectPage(
                new Query<LyUnitDetailEntity>(params).getPage(),
                new EntityWrapper<LyUnitDetailEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer addBrand(LyUnitDetailEntity entity) {
        if(StringUtils.isBlank(entity.getName())){
            throw new ObjectException(306,"名称不能为空");
        }
        List<LyUnitsEntity> list = unitsDao.selectList(new EntityWrapper<LyUnitsEntity>().eq("name", Constants.CAR_BRAND));
        if(list==null||list.size()<1){
            throw new ObjectException(306,"请先添加品牌单位，名称为"+Constants.CAR_BRAND);
        }
        entity.setUnitId(list.get(0).getId());
        detailDao.insert(entity);
        return null;
    }

    @Override
    public Integer updateDetail(LyUnitDetailEntity entity) {
        if(StringUtils.isBlank(entity.getName())){
            throw new ObjectException(306,"名称不能为空");
        }
        if(entity.getId()==null){
            throw new ObjectException(306,"参数不足");
        }
        detailDao.updateById(entity);
        return null;
    }

    @Override
    public Integer delDetail(Integer id) {
        List<LyOrderDetailEntity> list = orderDetailDao.selectList(new EntityWrapper<LyOrderDetailEntity>().eq("detail_id", id));
        if(list!=null&&list.size()>0){
            throw new ObjectException(305,"订单明细使用中，不能删除");
        }
        List<LyCarTypeEntity> typeList = carTypeDao.selectList(new EntityWrapper<LyCarTypeEntity>().eq("brand_id", id));
        if(typeList!=null&&typeList.size()>0){
            throw new ObjectException(305,"品牌使用中，不能删除");
        }
        detailDao.deleteById(id);
        return null;
    }

    @Override
    public Integer addDetail(LyUnitDetailEntity entity) {
        if(StringUtils.isBlank(entity.getName())||entity.getUnitId()==null){
            throw new ObjectException(305,"参数不足");
        }
        detailDao.insert(entity);
        return null;
    }

}
