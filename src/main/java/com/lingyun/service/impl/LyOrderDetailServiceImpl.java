package com.lingyun.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;

import com.lingyun.dao.LyOrderDetailDao;
import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.service.LyOrderDetailService;


@Service("lyOrderDetailService")
public class LyOrderDetailServiceImpl extends ServiceImpl<LyOrderDetailDao, LyOrderDetailEntity> implements LyOrderDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyOrderDetailEntity> page = this.selectPage(
                new Query<LyOrderDetailEntity>(params).getPage(),
                new EntityWrapper<LyOrderDetailEntity>()
        );

        return new PageUtils(page);
    }

}
