package com.lingyun.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.LyRoleEntity;
import com.lingyun.domain.from.LyRoleFrom;
import com.lingyun.service.LyRoleService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@Api("接口文档")
@RestController
@RequestMapping("lingyun/role")
public class LyRoleEndpoint {
    @Autowired
    private LyRoleService lyRoleService;

    @ApiOperation(value = "获取角色列表")
    @GetMapping("/list")
    public Response getRoleList(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Page<LyRoleFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(new HashMap<>());
        return Response.ok().put("data",lyRoleService.getRoleList(page));
    }

    @ApiOperation(value = "为角色设置添加权限菜单", notes = "参数")
    @PostMapping(value = "/set_menu_by_role")
    public Response setMenu4Role(@RequestBody Map map) {
        lyRoleService.setMenu4Role(map);
        return Response.ok();
    }

    @ApiOperation(value = "添加后台角色", notes = "参数")
    @PostMapping
    public Response addAdminRole(@RequestBody LyRoleEntity roleEntity) {
        lyRoleService.addAdminRole(roleEntity);
        return Response.ok();
    }

    @ApiOperation(value = "获取所有角色列表")
    @GetMapping("/get_all_role_list")
    public Response getAllRoleList(){
        return Response.ok().put("data",lyRoleService.selectList(new EntityWrapper<>()));
    }




}
