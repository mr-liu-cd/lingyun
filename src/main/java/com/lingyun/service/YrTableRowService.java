package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.dto.YrTableRowDTO;
import com.lingyun.domain.entity.YrTableRowEntity;
import com.lingyun.utils.PageUtils;

/**
 * <p>
 * 
 * <p/>
 *
 * @author liujie
 * @email " "
 * @date 2018-12-27 16:26:54
 */
public interface YrTableRowService extends IService<YrTableRowEntity> {

    /**
     * 获取表信息
     * @param page
     * @return
     */
    PageUtils getTableDetail(Page<YrTableRowDTO> page);
}

