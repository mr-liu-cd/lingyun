package com.lingyun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lingyun.domain.from.LyCustomerFrom;
import com.lingyun.utils.PageUtils;
import com.lingyun.domain.entity.LyCustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * <p/>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
public interface LyCustomerService extends IService<LyCustomerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getCustomerList(Page<LyCustomerFrom> page);

    Integer delCustomer(Integer id);

    List<LyCustomerEntity> getAllCustomer(String key);
}

