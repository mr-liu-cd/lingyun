package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.*;
import com.lingyun.domain.entity.LyUserEntity;
import com.lingyun.domain.from.LyMenuFrom;
import com.lingyun.domain.from.LyUserFrom;
import com.lingyun.exception.ObjectException;
import com.lingyun.security.TokenUtil;
import com.lingyun.service.LyUserService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.PwdUtil;
import com.lingyun.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("lyUserService")
public class LyUserServiceImpl extends ServiceImpl<LyUserDao, LyUserEntity> implements LyUserService {

    @Autowired
    private LyUserDao userDao;
    @Autowired
    private LyMenuDao menuDao;
    @Autowired
    private LyCustomerDao customerDao;
    @Autowired
    private LyCarDao carDao;
    @Autowired
    private LyOrderDao orderDao;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenUtil tokenUtil;

    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyUserEntity> page = this.selectPage(
                new Query<LyUserEntity>(params).getPage(),
                new EntityWrapper<LyUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public LyUserFrom userLogin(LyUserEntity entity) {
        if(StringUtils.isBlank(entity.getPassword())||StringUtils.isBlank(entity.getUsername())){
            throw new ObjectException(302,"参数不足");
        }
        String username = entity.getUsername();
        List<LyUserEntity> list = userDao.selectList(new EntityWrapper<LyUserEntity>().eq("username", username));
        if(list==null||list.size()<1){
            throw new ObjectException(302,"用户名不存在");
        }

        if(!encoder.matches(entity.getPassword(),list.get(0).getPassword())){
            throw new ObjectException(302,"密码错误");
        }

        //获取菜单
        List<LyMenuFrom> menus = menuDao.getMenuListByRoleId(list.get(0).getRoleId());
        List<LyMenuFrom> data=new ArrayList<>();
        for (LyMenuFrom menu : menus) {
            //将子菜单放到父菜单中去
            Integer pid = menu.getPid();
            if(pid!=null){
                for (LyMenuFrom spAdminMenuFrom : menus) {
                    if(spAdminMenuFrom.getId().equals(pid)){
                        List<LyMenuFrom> menulist = spAdminMenuFrom.getMenus();
                        if(menulist==null){menulist=new ArrayList<>();}
                        menulist.add(menu);
                        spAdminMenuFrom.setMenus(menulist);
                    }
                }
            }
        }
        for (LyMenuFrom menu : menus) {
            List<LyMenuFrom> menus1 = menu.getMenus();
            if(menus1!=null&&menus1.size()>0){
                data.add(menu);
            }
        }

        /**
         * security登录处理
         */
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(entity.getUsername(), entity.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);



        LyUserFrom from = new LyUserFrom();
        from.setUsername(username);
        from.setMenus(data);
        from.setToken(tokenUtil.createToken(username));
        return from;
    }

    @Override
    public Integer addUser(LyUserEntity entity) {
        if(StringUtils.isBlank(entity.getUsername())){
            throw new ObjectException(303,"用户名不能为空");
        }
        if(StringUtils.isBlank(entity.getPassword())){
            throw new ObjectException(303,"密码不能为空");
        }
        List<LyUserEntity> list = userDao.selectList(new EntityWrapper<LyUserEntity>().eq("username", entity.getUsername()));
        if(list!=null&&list.size()>0){
            throw new ObjectException(303,"用户名重复，请重新添加");
        }
        entity.setPassword(encoder.encode(entity.getPassword()));
        userDao.insert(entity);
        return null;
    }

    @Override
    public Integer updateUser(LyUserEntity entity) {
        if(entity.getId()==null){
            throw new ObjectException(303,"参数错误");
        }
        if(StringUtils.isNotBlank(entity.getPassword())){
            entity.setPassword(encoder.encode(entity.getPassword()));
        }
        userDao.updateById(entity);
        return null;
    }

    @Override
    public Integer delUser(Integer userId) {
        LyUserEntity entity = userDao.selectById(userId);
        if(entity==null){
            throw new ObjectException(303,"删除错误");
        }
        entity.setIsDelete(1);
        userDao.updateById(entity);
        return null;
    }

    @Override
    public PageUtils getAdminUser(Page<LyUserFrom> page) {
        Map map = page.getCondition();
        map.put("startNum", page.getOffset());
        map.put("perPage", page.getSize());
        page.setRecords(userDao.getAdminUser(map));
        page.setTotal(userDao.countAdminUser(map));
        return new PageUtils(page);
    }

    @Override
    public Map<String,Integer> getOverview() {
        Map map=new HashMap();
        map.put("orderNumber",orderDao.selectCount(new EntityWrapper<>()));
        map.put("customerNumber",customerDao.selectCount(new EntityWrapper<>()));
        map.put("carNumber",carDao.selectCount(new EntityWrapper<>()));
        return map;
    }

}
