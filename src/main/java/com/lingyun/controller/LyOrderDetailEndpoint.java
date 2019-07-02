package com.lingyun.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lingyun.domain.entity.LyOrderDetailEntity;
import com.lingyun.service.LyOrderDetailService;
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
@RequestMapping("lingyun/lyorderdetail")
public class LyOrderDetailEndpoint {
    @Autowired
    private LyOrderDetailService lyOrderDetailService;

    /**
     * 列表
     */
    @ApiOperation(value = "获取  列表}")
    @GetMapping("/list")
    public Response list(@RequestParam Map<String, Object> params) {
        PageUtils page = lyOrderDetailService.queryPage(params);

        return Response.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "获取  信息}")
    @GetMapping("/info/{id}")
    public Response info(@PathVariable("id") Integer id) {
            LyOrderDetailEntity lyOrderDetail = lyOrderDetailService.selectById(id);
        return Response.ok().put("lyOrderDetail", lyOrderDetail);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存  信息")
    @PostMapping("/save")
    public Response save(@RequestBody LyOrderDetailEntity lyOrderDetail) {
            lyOrderDetailService.insert(lyOrderDetail);

        return Response.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改  信息}")
    @PutMapping("/update")
    public Response update(@RequestBody LyOrderDetailEntity lyOrderDetail) {
            lyOrderDetailService.updateAllColumnById(lyOrderDetail);//全部更新
        return Response.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除  信息}")
    @DeleteMapping("/delete")
    public Response delete(@RequestBody Integer[]ids) {
            lyOrderDetailService.deleteBatchIds(Arrays.asList(ids));

        return Response.ok();
    }

}
