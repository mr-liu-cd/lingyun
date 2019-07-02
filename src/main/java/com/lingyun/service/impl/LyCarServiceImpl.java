package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.LyCarDao;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.domain.from.LyCarFrom;
import com.lingyun.exception.ObjectException;
import com.lingyun.service.LyCarService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("lyCarService")
public class LyCarServiceImpl extends ServiceImpl<LyCarDao, LyCarEntity> implements LyCarService {

    @Autowired
    private LyCarDao carDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyCarEntity> page = this.selectPage(
                new Query<LyCarEntity>(params).getPage(),
                new EntityWrapper<LyCarEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getCarList(Page<LyCarFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(carDao.getCarList(map));
        page.setTotal(carDao.countCarList(map));
        return new PageUtils(page);
    }

    @Override
    public Integer addCar(LyCarEntity entity) {
        Integer carType = entity.getCarType();
        Integer customerId = entity.getCustomerId();
        if(carType==null||customerId==null){
            throw new ObjectException(306,"请填写车型或者用户信息");
        }
        if(StringUtils.isBlank(entity.getLicense())){
            throw new ObjectException(306,"请填写车牌号信息");
        }
        if(entity.getInsuranceTime()==null||entity.getAnnualInspectionTime()==null){
            throw new ObjectException(306,"保险日期或者年检日期为空");
        }
        carDao.insert(entity);
        return null;
    }

    @Override
    public Integer updateCar(LyCarEntity entity) {
        if(entity.getAnnualInspectionTime()==null||entity.getInsuranceTime()==null||StringUtils.isBlank(entity.getLicense())){
            throw new ObjectException(305,"参数不足");
        }
        carDao.updateById(entity);
        return null;
    }

    @Override
    public List<LyOrderDto> getInfoByLicense(String key) {
        return carDao.getInfoByLicense(key);
    }

    @Override
    public List<LyOrderDto> getInfoByName(String key) {
        List<LyOrderDto> list = carDao.getInfoByName(key);
        for (LyOrderDto lyOrderDto : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(lyOrderDto.getName()+"-");
            sb.append(lyOrderDto.getTypeName()+"-");
            sb.append(lyOrderDto.getLicense());
            lyOrderDto.setDesc(sb.toString());
        }
        return list;
    }

    @Override
    public PageUtils getInsuranceCar(Page<LyCarFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(carDao.getInsuranceCar(map));
        page.setTotal(carDao.countInsuranceCar(map));
        return new PageUtils(page);
    }

    @Override
    public PageUtils getAnnualInspectionCar(Page<LyCarFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        page.setRecords(carDao.getAnnualInspectionCar(map));
        page.setTotal(carDao.countAnnualInspectionCar(map));
        return new PageUtils(page);
    }

}
