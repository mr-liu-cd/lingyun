package com.lingyun.service;

import com.baomidou.mybatisplus.service.IService;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyUnitDetailEntity;

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
public interface LyUnitDetailService extends IService<LyUnitDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer addBrand(LyUnitDetailEntity entity);

    Integer updateDetail(LyUnitDetailEntity entity);

    Integer delDetail(Integer id);

    Integer addDetail(LyUnitDetailEntity entity);
}

