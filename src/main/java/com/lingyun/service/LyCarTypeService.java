package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.from.LyCarTypeFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyCarTypeEntity;

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
public interface LyCarTypeService extends IService<LyCarTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getCarTypeList(Page<LyCarTypeFrom> page);

    Integer addCarType(LyCarTypeEntity entity);

    Integer updateCartType(LyCarTypeEntity entity);

    Integer delCarType(Integer carTypeId);

    List<LyCarTypeEntity> getCarTypeByBrand(Integer brandId);
}

