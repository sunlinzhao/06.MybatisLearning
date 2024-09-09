package com.slz.multi.model;

import lombok.Data;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */

@Data
public class Team {
    private int tid;
    private String tname;
    private List<Player> players;
}
