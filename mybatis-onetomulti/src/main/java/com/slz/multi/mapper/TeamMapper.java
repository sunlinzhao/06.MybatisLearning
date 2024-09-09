package com.slz.multi.mapper;

import com.slz.multi.model.Team;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
public interface TeamMapper {
    List<Team> selectList();
}
