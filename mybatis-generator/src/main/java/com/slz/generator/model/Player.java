package com.slz.generator.model;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/10
 */

import lombok.Data;
@Data
public class Player {
    private int pid;
    private String pname;
    private int tid;
    private Team team;
}
