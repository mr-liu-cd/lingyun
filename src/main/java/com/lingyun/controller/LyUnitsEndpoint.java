package com.lingyun.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.LyUnitDetailEntity;
import com.lingyun.domain.entity.LyUnitsEntity;
import com.lingyun.domain.from.LyUnitsDetailFrom;
import com.lingyun.service.LyUnitsService;
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
@RequestMapping("lingyun/units")
public class LyUnitsEndpoint {
    @Autowired
    private LyUnitsService lyUnitsService;

    @ApiOperation(value = "根据单位id，获取所有明细")
    @GetMapping("/get_detail_by_unit")
    public Response getDetailByUnit(@RequestParam Integer unitId){
        return Response.ok().put("data",lyUnitsService.getDetailByUnit(unitId));
    }

    @ApiOperation(value = "获取所有单位类型")
    @GetMapping("/get_all_units")
    public Response getAllUnits(){
        return Response.ok().put("data",lyUnitsService.selectList(new EntityWrapper<>()));
    }

    @ApiOperation(value = "获取所有品牌")
    @GetMapping("/get_brand_list")
    public Response getBrandList(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Page<LyUnitDetailEntity> page = new Page<>(pageNum, pageSize);
        page.setCondition(new HashMap<>());
        return Response.ok().put("data",lyUnitsService.getBrandList(page));
    }
    @ApiOperation(value = "分页获取所有类型数据明细")
    @GetMapping("/get_page_detail_by_unit")
    public Response getPageDetailByUnit(@RequestParam Integer pageNum,@RequestParam Integer pageSize,Integer unitId){
        Map map=new HashMap();
        if(unitId!=null){
            map.put("unitId",unitId);
        }
        Page<LyUnitsDetailFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",lyUnitsService.getPageDetailByUnit(page));
    }

    @ApiOperation(value = "分页获取所有数据类型")
    @GetMapping("/list")
    public Response getUnitsList(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Page<LyUnitsEntity> page = new Page<>();
        page.setCondition(new HashMap<>());
        return Response.ok().put("data",lyUnitsService.getUnitsList(page));
    }

    @ApiOperation(value = "添加数据类型")
    @PostMapping
    public Response addUnits(@RequestBody LyUnitsEntity entity){
        lyUnitsService.addUnits(entity);
        return Response.ok();
    }
    @ApiOperation(value = "修改数据类型")
    @PutMapping
    public Response updateUnits(@RequestBody LyUnitsEntity entity){
        lyUnitsService.updateUnits(entity);
        return Response.ok();
    }
    @ApiOperation(value = "删除数据类型")
    @DeleteMapping
    public Response delUnits(@RequestParam Integer id){
        lyUnitsService.delUnits(id);
        return Response.ok();
    }
}
