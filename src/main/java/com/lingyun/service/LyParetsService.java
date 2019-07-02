package com.lingyun.service;

import com.baomidou.mybatisplus.service.IService;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyParetsEntity;

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
public interface LyParetsService extends IService<LyParetsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

