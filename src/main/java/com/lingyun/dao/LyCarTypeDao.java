package com.lingyun.dao;

import com.lingyun.domain.entity.LyCarTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.from.LyCarTypeFrom;

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
public interface LyCarTypeDao extends BaseMapper<LyCarTypeEntity> {

    List<LyCarTypeFrom> getCarTypeList(Map<String, Object> map);

    Integer countCarTypeList(Map<String, Object> map);
}
