package com.lingyun.dao;

import com.lingyun.domain.entity.LyUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.from.LyUserFrom;

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
public interface LyUserDao extends BaseMapper<LyUserEntity> {


    List<LyUserFrom> getAdminUser(Map map);

    Integer countAdminUser(Map map);

}
