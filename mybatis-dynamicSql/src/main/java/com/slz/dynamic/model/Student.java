package com.slz.dynamic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */
@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
}
