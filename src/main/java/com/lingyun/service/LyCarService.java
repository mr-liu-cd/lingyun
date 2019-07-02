package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.from.LyCarFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyCarEntity;

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
public interface LyCarService extends IService<LyCarEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getCarList(Page<LyCarFrom> page);

    Integer addCar(LyCarEntity entity);

    Integer updateCar(LyCarEntity entity);

    List<LyOrderDto> getInfoByLicense(String key);

    List<LyOrderDto> getInfoByName(String key);

    PageUtils getInsuranceCar(Page<LyCarFrom> page);

    PageUtils getAnnualInspectionCar(Page<LyCarFrom> page);
}

