package com.lingyun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lingyun.domain.entity.YrTableEntity;
import com.lingyun.service.YrTableService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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
@RequestMapping("lingyun/table")
public class YrTableEndpoint {
    @Autowired
    private YrTableService tableService;

    @ApiOperation(value = "excel上传")
    @PostMapping
    public Response excelUpload(@RequestParam String name, @RequestParam MultipartFile file){
        tableService.excelUpload(name,file);
        return Response.ok();
    }

    @ApiOperation(value = "获取表列表")
    @GetMapping("/list")
    public Response getTableList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,String key){
        Map map=new HashMap();
        if(StringUtils.isNotBlank(key)){
            map.put("key","%"+key+"%");
        }
        Page<YrTableEntity> page = new Page<>(pageNum, pageSize);
        page.setCondition(map);
        return Response.ok().put("data",tableService.getTableList(page));
    }

    @ApiOperation(value = "添加行")
    @PutMapping("/add_table_row/{tableId}")
    public Response addTableRow(@RequestBody Map map,@PathVariable("tableId") Integer tableId ){
        tableService.addTableRow(tableId,map);
        return Response.ok();
    }

    @ApiOperation(value = "修改行")
    @PutMapping("/update_table_val/{tableId}/{line}")
    public Response updateTableVal(@RequestBody Map map,@PathVariable("tableId") Integer tableId,@PathVariable("line") Integer line){
        tableService.updateTableVal(tableId,map,line);
        return Response.ok();
    }

    @ApiOperation(value = "删除行")
    @DeleteMapping
    public Response deleteRow(@RequestParam Integer tableId,@RequestParam Integer line){
        tableService.deleteRow(tableId,line);
        return Response.ok();
    }

    @ApiOperation(value = "删除表")
    @DeleteMapping("/delete_table")
    public Response deleteTable(@RequestParam Integer tableId){
        tableService.deleteTable(tableId);
        return Response.ok();
    }
}
