package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lingyun.dao.LyUserDao;
import com.lingyun.domain.entity.LyUserEntity;
import com.lingyun.exception.ObjectException;
import com.lingyun.security.LyUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LyUserDetailService implements UserDetailsService {

    @Autowired
    private LyUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<LyUserEntity> list = userDao.selectList(new EntityWrapper<LyUserEntity>().eq("username", s));
        if(list!=null&&list.size()>0){
            LyUserEntity entity = list.get(0);
            LyUserDetails details = new LyUserDetails();
            BeanUtils.copyProperties(entity,details);
            return details;
        }
       throw new ObjectException(305,"该账户未注册");
    }
}
