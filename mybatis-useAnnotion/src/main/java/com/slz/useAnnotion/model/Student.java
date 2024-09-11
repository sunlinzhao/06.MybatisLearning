package com.slz.useAnnotion.model;

import lombok.Data;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/11
 */

@Data
public class Student {
    private int id;
    private String sname;
    private int age;
    private String gender;
}
