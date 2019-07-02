package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.LyRoleEntity;
import com.lingyun.domain.from.LyRoleFrom;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
public interface LyRoleDao extends BaseMapper<LyRoleEntity> {

    /**
     * 获取角色列表
     * @param map
     * @return
     */
    List<LyRoleFrom> getRoleList(Map<String, Object> map);

    Integer countRoleList(Map<String, Object> map);

    Integer clearMenu4Role(Integer roleId);

    Integer setMenu4Role(Map map);
}
