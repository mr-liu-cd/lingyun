package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.config.Constants;
import com.lingyun.dao.LyUnitDetailDao;
import com.lingyun.dao.LyUnitsDao;
import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.lingyun.domain.entity.LyUnitsEntity;
import com.lingyun.domain.from.LyUnitsDetailFrom;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.LyUnitsService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("lyUnitsService")
public class LyUnitsServiceImpl extends ServiceImpl<LyUnitsDao, LyUnitsEntity> implements LyUnitsService {

    @Autowired
    private LyUnitDetailDao detailDao;

    @Autowired
    private LyUnitsDao unitsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyUnitsEntity> page = this.selectPage(
                new Query<LyUnitsEntity>(params).getPage(),
                new EntityWrapper<LyUnitsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LyUnitDetailEntity> getDetailByUnit(Integer unitId) {
        return detailDao.selectList(new EntityWrapper<LyUnitDetailEntity>().eq("unit_id",unitId));
    }

    @Override
    public PageUtils getBrandList(Page<LyUnitDetailEntity> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        //根据名称查询单位
        map.put("name",Constants.CAR_BRAND);
        page.setRecords(detailDao.getBrandList(map));
        page.setTotal(detailDao.countBrandList(map));
        return new PageUtils(page);
    }

    @Override
    public PageUtils getPageDetailByUnit(Page<LyUnitsDetailFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(detailDao.getPageDetailByUnit(map));
        page.setTotal(detailDao.countPageDetailByUnit(map));
        return new PageUtils(page);
    }

    @Override
    public PageUtils getUnitsList(Page<LyUnitsEntity> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(detailDao.getUnitsList(map));
        page.setTotal(detailDao.countUnitsList(map));
        return new PageUtils(page);
    }

    @Override
    public Integer addUnits(LyUnitsEntity entity) {
        if(StringUtils.isBlank(entity.getDesc())||StringUtils.isBlank(entity.getName())){
            throw new ObjectException(306,"参数不足");
        }
        unitsDao.insert(entity);
        return null;
    }

    @Override
    public Integer updateUnits(LyUnitsEntity entity) {
        Integer id = entity.getId();
        if(id==null){
            throw new ObjectException(305,"参数异常");
        }
        List<LyUnitsEntity> list = unitsDao.selectList(new EntityWrapper<LyUnitsEntity>().eq("name", Constants.CAR_BRAND));
        if(list!=null&&list.size()>0){
            if(entity.getId().equals(list.get(0).getId())){
                entity.setName(null);
            }
        }
        if(StringUtils.isNotBlank(entity.getName())){
            if(Constants.CAR_BRAND.equals(entity.getName())){
                throw new ObjectException(305,"名称不能与品牌名称属性一致");
            }
        }

        unitsDao.updateById(entity);
        return null;
    }

    @Override
    public Integer delUnits(Integer id) {
        List<LyUnitDetailEntity> list = detailDao.selectList(new EntityWrapper<LyUnitDetailEntity>().eq("unit_id", id));
        if(list!=null&&list.size()>0){
            throw new ObjectException(305,"请先删除该类型包含的明细");
        }
        unitsDao.deleteById(id);
        return null;
    }

}
