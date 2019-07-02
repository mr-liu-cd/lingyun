package com.lingyun.dao;

import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.LyUnitsEntity;
import com.lingyun.domain.from.LyUnitsDetailFrom;

import java.util.List;
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
public interface LyUnitDetailDao extends BaseMapper<LyUnitDetailEntity> {

    List<LyUnitDetailEntity> getBrandList(Map<String, Object> map);

    Integer countBrandList(Map<String, Object> map);

    List<LyUnitsDetailFrom> getPageDetailByUnit(Map<String, Object> map);

    Integer countPageDetailByUnit(Map<String, Object> map);

    List<LyUnitsEntity> getUnitsList(Map<String, Object> map);

    Integer countUnitsList(Map<String, Object> map);
}
