package com.lingyun.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lingyun.domain.dto.LyOrderDto;
import com.lingyun.domain.entity.LyCarEntity;
import com.lingyun.domain.from.LyCarFrom;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface LyCarDao extends BaseMapper<LyCarEntity> {

    List<LyCarFrom> getCarList(Map<String, Object> map);

    Integer countCarList(Map<String, Object> map);

    List<LyOrderDto> getInfoByLicense(String key);

    List<LyOrderDto> getInfoByName(String key);

    List<LyCarFrom> getInsuranceCar(Map<String, Object> map);

    Integer countInsuranceCar(Map<String, Object> map);

    List<LyCarFrom> getAnnualInspectionCar(Map<String, Object> map);

    Integer countAnnualInspectionCar(Map<String, Object> map);
}
