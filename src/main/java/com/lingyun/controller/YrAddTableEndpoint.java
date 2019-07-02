package com.lingyun.controller;

import com.lingyun.domain.entity.YrAddTableConditionEntity;
import com.lingyun.domain.entity.YrAddTableEntity;
import com.lingyun.domain.entity.YrAddTableRowEntity;
import com.lingyun.service.YrAddTableService;
import com.lingyun.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  新建空表
 * </p>
 *
 * @author liujie
 * @email " "
 * @date 2019-01-22 14:31:25
 */
@Api("新建空表接口文档")
@RestController
@RequestMapping("bookhotel/add_table")
public class YrAddTableEndpoint {
    @Autowired
    private YrAddTableService yrAddTableService;

    @ApiOperation(value = "添加新增表")
    @PostMapping
    public Response addNewTable(@RequestBody YrAddTableEntity entity){
        yrAddTableService.addNewTable(entity);
        return Response.ok();
    }

    @ApiOperation(value = "添加新增表，列信息")
    @PostMapping("/add_table_row")
    public Response addTableRow(@RequestBody YrAddTableRowEntity rowEntity){
        yrAddTableService.addTableRow(rowEntity);
        return Response.ok();
    }

    @ApiOperation(value = "添加新增表，条件信息")
    @PostMapping("/add_table_condition")
    public Response addTableCondition(@RequestBody YrAddTableConditionEntity entity){
        yrAddTableService.addTableCondition(entity);
        return Response.ok();
    }

    @ApiOperation(value = "新增表，数据填充")
    @PutMapping
    public Response tableDataFill(@RequestParam Integer tableId){
        yrAddTableService.tableDataFill(tableId);
        return Response.ok();
    }

}
