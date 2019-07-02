package com.lingyun.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.from.LyCarFrom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.service.LyCarService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Response;


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
@RequestMapping("lingyun/car")
public class LyCarEndpoint {
    @Autowired
    private LyCarService lyCarService;

    @ApiOperation(value = "分页获取汽车")
    @GetMapping("/list")
    public Response getCarList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,Integer brandId,String key){
        Map map=new HashMap();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        if(brandId!=null){
            map.put("brandId",brandId);
        }
        Page<LyCarFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyCarService.getCarList(page));
    }

    @ApiOperation(value = "添加汽车")
    @PostMapping
    public Response addCar(@RequestBody LyCarEntity entity){
        lyCarService.addCar(entity);
        return  Response.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public Response updateCar(@RequestBody LyCarEntity entity){
        lyCarService.updateCar(entity);
        return Response.ok();
    }

    @ApiOperation(value = "根据车牌号模糊查询车以及顾客信息")
    @GetMapping("/get_info_by_license")
    public Response getInfoByLicense(@RequestParam String key){
        return Response.ok().put("data",lyCarService.getInfoByLicense("%"+key+"%"));
    }

    @ApiOperation(value = "根据姓名查询车以及客户信息")
    @GetMapping("/get_info_by_name")
    public Response getInfoByName(@RequestParam String key){
        return Response.ok().put("data",lyCarService.getInfoByName("%"+key+"%"));
    }

    @ApiOperation(value = "获取所有保险到期的车")
    @GetMapping("/get_insurance_car")
    public Response getInsuranceCar(@RequestParam Integer pageNum,@RequestParam Integer pageSize,String key){
        Map map=new HashMap<>();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        Page<LyCarFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyCarService.getInsuranceCar(page));
    }
    @ApiOperation(value = "获取所有年检到期的车")
    @GetMapping("/get_annual_inspection_car")
    public Response getAnnualInspectionCar(@RequestParam Integer pageNum,@RequestParam Integer pageSize ,String key){
        Map map=new HashMap<>();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        Page<LyCarFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyCarService.getAnnualInspectionCar(page));
    }
}
