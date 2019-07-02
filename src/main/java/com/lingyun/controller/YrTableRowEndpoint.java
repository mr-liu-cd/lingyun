package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.dto.YrTableRowDTO;
import com.lingyun.service.YrTableRowService;
import com.lingyun.utils.PageUtils;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  
 * </p>
 *
 * @author liujie
 * @email " "
 * @date 2018-12-27 16:26:54
 */
@Api("接口文档")
@RestController
@RequestMapping("lingyun/table_row")
public class YrTableRowEndpoint {
    @Autowired
    private YrTableRowService yrTableRowService;

    @ApiOperation(value = "获取表信息")
    @GetMapping("/list")
    public Response getTableDetail(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam Integer tableId,String key,Integer line){
        Map map=new HashMap();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        if(line!=null){
            map.put("line",line);
        }
        map.put("tableId",tableId);
        Page<YrTableRowDTO> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",yrTableRowService.getTableDetail(page));
    }

}
