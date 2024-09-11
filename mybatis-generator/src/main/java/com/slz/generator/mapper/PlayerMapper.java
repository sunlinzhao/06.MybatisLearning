package com.slz.generator.mapper;

import com.slz.generator.model.Player;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/11
 */
public interface PlayerMapper {
    Player selectId(int pid);
    List<Player> selectList();
    List<Player> selectByTid(int tid);
}
