package com.slz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/20
 */
@Data
@Accessors(chain = true) // 链式编程，允许类对象作链式处理（调用结果返回当前对象就可以）
@AllArgsConstructor // 给该类加一个包含所有参数的构造方法
@NoArgsConstructor // 给该类加一个无参的构造方法
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;

    // 下面代码 可解释 @Accessors(chain = true)
//    public Student setAge(int age) {
//        this.age = age;
//        return this;
//    }
}
