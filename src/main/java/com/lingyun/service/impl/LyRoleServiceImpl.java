package com.lingyun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lingyun.dao.LyMenuDao;
import com.lingyun.dao.LyRoleDao;
import com.lingyun.domain.entity.LyRoleEntity;
import com.lingyun.domain.from.LyMenuFrom;
import com.lingyun.domain.from.LyRoleFrom;
import com.lingyun.service.LyRoleService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("lyRoleService")
public class LyRoleServiceImpl extends ServiceImpl<LyRoleDao, LyRoleEntity> implements LyRoleService {

    @Autowired
    private LyRoleDao roleDao;

    @Autowired
    private LyMenuDao menuDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LyRoleEntity> page = this.selectPage(
                new Query<LyRoleEntity>(params).getPage(),
                new EntityWrapper<LyRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getRoleList(Page<LyRoleFrom> page) {
        Map<String, Object> map = page.getCondition();
        map.put("startNum",page.getOffset());
        map.put("perPage",page.getSize());
        List<LyRoleFrom> list = roleDao.getRoleList(map);
        for (LyRoleFrom lyRoleFrom : list) {
            List<LyMenuFrom> menus = menuDao.getMenuListByRole(lyRoleFrom.getId());
            lyRoleFrom.setMenus(menus);
        }
        page.setRecords(list);
        page.setTotal(roleDao.countRoleList(map));
        return new PageUtils(page);
    }

    @Override
    public void setMenu4Role(Map map) {
        Integer roleId = (Integer) map.get("roleId");
        List<Integer> menuIdList = (List<Integer>) map.get("menuIdList");
        map.clear();
        roleDao.clearMenu4Role(roleId);
        map.put("roleId", roleId);
        for (Integer menuId : menuIdList) {
            map.put("menuId", menuId);
            roleDao.setMenu4Role(map);
        }
    }

    @Override
    public void addAdminRole(LyRoleEntity roleEntity) {
        roleDao.insert(roleEntity);
    }

}
