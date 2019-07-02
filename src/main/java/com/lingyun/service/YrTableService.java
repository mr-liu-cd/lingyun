package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.entity.YrTableEntity;
import com.lingyun.utils.PageUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>
 * 
 * <p/>
 *
 * @author liujie
 * @email " "
 * @date 2018-12-27 16:26:54
 */
public interface YrTableService extends IService<YrTableEntity> {

    /**
     * excel上传
     * @param name
     * @param file
     * @return
     */
    Integer excelUpload(String name, MultipartFile file);

    /**
     * 获取excel表列表
     * @param page
     * @return
     */
    PageUtils getTableList(Page<YrTableEntity> page);

    /**
     * 添加行
     * @param tableId
     * @return
     */
    Integer addTableRow(Integer tableId, Map map);

    /**
     * 删除行
     * @param tableId
     * @param line
     * @return
     */
    Integer deleteRow(Integer tableId, Integer line);

    /**
     * 修改行
     * @param tableId
     * @param line
     * @return
     */
    Integer updateTableVal(Integer tableId, Map map, Integer line);

    /**
     * 删除表
     * @param tableId
     * @return
     */
    Integer deleteTable(Integer tableId);
}

