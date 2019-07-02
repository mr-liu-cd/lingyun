package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.LyUserEntity;
import com.lingyun.domain.from.LyUserFrom;
import com.lingyun.service.LyUserService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


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
@RequestMapping("lingyun/user")
public class LyUserEndpoint {
    @Autowired
    private LyUserService lyUserService;

    @ApiOperation(value = "登录")
    @PostMapping("/admin_user_login")
    public Response adminUserLogin(@RequestBody LyUserEntity entity){
        return Response.ok().put("data",lyUserService.userLogin(entity));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Response addUser(@RequestBody LyUserEntity entity){
        lyUserService.addUser(entity);
        return Response.ok();
    }
    @ApiOperation(value = "修改用户")
    @PutMapping
    public Response updateUser(@RequestBody LyUserEntity entity){
        lyUserService.updateUser(entity);
        return Response.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping
    public Response delUser(@RequestParam Integer id){
        lyUserService.delUser(id);
        return Response.ok();
    }
    @ApiOperation(value = "预览")
    @GetMapping("/get_overview")
    public Response getOverview(){
        return Response.ok().put("data",lyUserService.getOverview());
    }

    @ApiOperation(value = "分页获取所有后台用户", notes = "参数")
    @GetMapping(value = "/get_admin_user")
    public Response getAdminUser(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        Page<LyUserFrom> page = new Page(pageNum,pageSize);
        page.setCondition(new HashMap<>());
        PageUtils pageUtils = lyUserService.getAdminUser(page);
        return Response.ok().put("data",pageUtils);
    }


}
