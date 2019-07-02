package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.lingyun.domain.from.LyUnitsDetailFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyUnitsEntity;

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
public interface LyUnitsService extends IService<LyUnitsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LyUnitDetailEntity> getDetailByUnit(Integer unitId);

    PageUtils getBrandList(Page<LyUnitDetailEntity> page);

    PageUtils getPageDetailByUnit(Page<LyUnitsDetailFrom> page);

    PageUtils getUnitsList(Page<LyUnitsEntity> page);

    Integer addUnits(LyUnitsEntity entity);

    Integer updateUnits(LyUnitsEntity entity);

    Integer delUnits(Integer id);
}

