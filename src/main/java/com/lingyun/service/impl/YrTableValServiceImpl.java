package com.lingyun.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.YrTableValDao;
import com.lingyun.domain.entity.YrTableValEntity;
import com.lingyun.service.YrTableValService;
import org.springframework.stereotype.Service;


@Service("yrTableValService")
public class YrTableValServiceImpl extends ServiceImpl<YrTableValDao, YrTableValEntity> implements YrTableValService {


}
