package com.lingyun.dao;

import com.lingyun.domain.entity.LyCustomerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.from.LyCustomerFrom;

import java.util.List;
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
public interface LyCustomerDao extends BaseMapper<LyCustomerEntity> {

    List<LyCustomerFrom> getCustomerList(Map<String, Object> map);

    Integer countCustomerList(Map<String, Object> map);
}
