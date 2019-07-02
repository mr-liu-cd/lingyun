package com.lingyun.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lingyun.domain.entity.LyMenuEntity;
import com.lingyun.service.LyMenuService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
@RequestMapping("lingyun/menu")
public class LyMenuEndpoint {
    @Autowired
    private LyMenuService lyMenuService;

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("/list")
    public Response getMenuByRole() {
        return Response.ok().put("data", lyMenuService.selectList(new EntityWrapper<LyMenuEntity>().isNotNull("pid")));

    }
}
