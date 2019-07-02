package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.from.LyRoleFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyRoleEntity;

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
public interface LyRoleService extends IService<LyRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取角色列表
     * @param page
     * @return
     */
    PageUtils getRoleList(Page<LyRoleFrom> page);

    void setMenu4Role(Map map);

    void addAdminRole(LyRoleEntity roleEntity);
}

