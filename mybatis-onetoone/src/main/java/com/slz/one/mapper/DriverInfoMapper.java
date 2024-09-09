package com.slz.one.mapper;

import com.slz.one.model.DriverQuery;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public interface DriverInfoMapper {
    List<DriverQuery> selectList();
}
