package com.lingyun.controller;

import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.lingyun.service.LyUnitDetailService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("lingyun/unit_detail")
public class LyUnitDetailEndpoint {
    @Autowired
    private LyUnitDetailService lyUnitDetailService;

    @ApiOperation(value = "添加品牌")
    @PostMapping("/add_brand")
    public Response addBrand(@RequestBody LyUnitDetailEntity entity){
        lyUnitDetailService.addBrand(entity);
        return Response.ok();
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Response addDetail(@RequestBody LyUnitDetailEntity entity){
        lyUnitDetailService.addDetail(entity);
        return Response.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public Response updateDetail(@RequestBody LyUnitDetailEntity entity){
        lyUnitDetailService.updateDetail(entity);
        return Response.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping
    public Response delDetail(@RequestParam Integer id){
        lyUnitDetailService.delDetail(id);
        return Response.ok();
    }

}
