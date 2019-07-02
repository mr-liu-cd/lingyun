package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.LyCarTypeEntity;
import com.lingyun.domain.from.LyCarTypeFrom;
import com.lingyun.service.LyCarTypeService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
@RequestMapping("lingyun/car_type")
public class LyCarTypeEndpoint {
    @Autowired
    private LyCarTypeService lyCarTypeService;

    @ApiOperation(value = "分页获取所有车类型")
    @GetMapping("/list")
    public Response getCarTypeList(@RequestParam Integer pageSize,@RequestParam Integer pageNum){
        Page<LyCarTypeFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(new HashMap<>());
        return Response.ok().put("data",lyCarTypeService.getCarTypeList(page));
    }

    @ApiOperation(value = "添加车型")
    @PostMapping()
    public Response addCarType(@RequestBody LyCarTypeEntity entity){
        lyCarTypeService.addCarType(entity);
        return Response.ok();
    }

    @ApiOperation(value = "修改车型")
    @PutMapping
    public Response updateCarType(@RequestBody LyCarTypeEntity entity){
        lyCarTypeService.updateCartType(entity);
        return Response.ok();
    }

    @ApiOperation(value = "删除车型")
    @DeleteMapping
    public Response delCarType(@RequestParam Integer carTypeId){
        lyCarTypeService.delCarType(carTypeId);
        return Response.ok();
    }

    @ApiOperation(value = "根据品牌获取车型")
    @GetMapping("/get_car_type_by_brand")
    public Response getCarTypeByBrand(@RequestParam Integer brandId){
        return Response.ok().put("data",lyCarTypeService.getCarTypeByBrand(brandId));
    }

}
