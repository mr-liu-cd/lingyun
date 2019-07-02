package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.LyCustomerEntity;
import com.lingyun.domain.from.LyCustomerFrom;
import com.lingyun.service.LyCustomerService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("lingyun/customer")
public class LyCustomerEndpoint {
    @Autowired
    private LyCustomerService lyCustomerService;

    @ApiOperation(value = "客户列表查看")
    @GetMapping("/list")
    public Response getCustomerList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,String key){
        Map map=new HashMap();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        Page<LyCustomerFrom> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return  Response.ok().put("data",lyCustomerService.getCustomerList(page));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Response addCustomer(@RequestBody LyCustomerEntity entity){
        lyCustomerService.insert(entity);
        return Response.ok();
    }

    @ApiOperation(value = "修改用户")
    @PutMapping
    public Response updateCustomer(@RequestBody LyCustomerEntity entity){
        lyCustomerService.updateById(entity);
        return Response.ok();
    }
    @ApiOperation(value = "删除用户")
    @DeleteMapping
    public Response delCustomer(@RequestParam Integer id){
        lyCustomerService.delCustomer(id);
        return Response.ok();
    }

    @ApiOperation(value = "获取所有用户")
    @GetMapping("/get_all_customer")
    public Response getAllCustomer(String key){
        return Response.ok().put("data",lyCustomerService.getAllCustomer(key));
    }


}
