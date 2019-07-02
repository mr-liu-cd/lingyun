package com.lingyun.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;

import com.lingyun.dao.LyMenuDao;
import com.lingyun.domain.entity.LyMenuEntity;
import com.lingyun.service.LyMenuService;


@Service("lyMenuService")
public class LyMenuServiceImpl extends ServiceImpl<LyMenuDao, LyMenuEntity> implements LyMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyMenuEntity> page = this.selectPage(
                new Query<LyMenuEntity>(params).getPage(),
                new EntityWrapper<LyMenuEntity>()
        );

        return new PageUtils(page);
    }

}
