package com.lingyun.service;

import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.entity.LyMenuEntity;
import com.lingyun.utils.PageUtils;

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
public interface LyMenuService extends IService<LyMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

