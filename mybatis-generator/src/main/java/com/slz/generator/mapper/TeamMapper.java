package com.slz.generator.mapper;

import com.slz.generator.model.Team;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/11
 */
public interface TeamMapper {
    Team selectById(int tid);
    List<Team> selectList();
}
