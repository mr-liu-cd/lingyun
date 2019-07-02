package com.lingyun.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;

import com.lingyun.dao.LyParetsDao;
import com.lingyun.domain.entity.LyParetsEntity;
import com.lingyun.service.LyParetsService;


@Service("lyParetsService")
public class LyParetsServiceImpl extends ServiceImpl<LyParetsDao, LyParetsEntity> implements LyParetsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyParetsEntity> page = this.selectPage(
                new Query<LyParetsEntity>(params).getPage(),
                new EntityWrapper<LyParetsEntity>()
        );

        return new PageUtils(page);
    }

}
