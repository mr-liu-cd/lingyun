package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.entity.LyMenuEntity;
import com.lingyun.domain.from.LyMenuFrom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LyMenuDao extends BaseMapper<LyMenuEntity> {

    List<LyMenuFrom> getMenuListByRoleId(Integer roleId);

    /**
     * 根据角色获取菜单。不包含父菜单
     *
     * @param roleId
     * @return
     */
    List<LyMenuFrom> getMenuListByRole(Integer roleId);
}