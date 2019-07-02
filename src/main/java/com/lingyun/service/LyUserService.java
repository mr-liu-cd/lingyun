package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.entity.LyUserEntity;
import com.lingyun.domain.from.LyUserFrom;
import com.lingyun.utils.PageUtils;

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
public interface LyUserService extends IService<LyUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    LyUserFrom userLogin(LyUserEntity entity);

    Integer addUser(LyUserEntity entity);

    Integer updateUser(LyUserEntity entity);

    Integer delUser(Integer userId);

    PageUtils getAdminUser(Page<LyUserFrom> page);

    Map<String,Integer> getOverview();
}

