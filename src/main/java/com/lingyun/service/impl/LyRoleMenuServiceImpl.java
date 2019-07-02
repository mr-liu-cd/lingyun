package com.lingyun.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;

import com.lingyun.dao.LyRoleMenuDao;
import com.lingyun.domain.entity.LyRoleMenuEntity;
import com.lingyun.service.LyRoleMenuService;


@Service("lyRoleMenuService")
public class LyRoleMenuServiceImpl extends ServiceImpl<LyRoleMenuDao, LyRoleMenuEntity> implements LyRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyRoleMenuEntity> page = this.selectPage(
                new Query<LyRoleMenuEntity>(params).getPage(),
                new EntityWrapper<LyRoleMenuEntity>()
        );

        return new PageUtils(page);
    }

}
