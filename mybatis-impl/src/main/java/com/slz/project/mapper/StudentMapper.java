package com.slz.project.mapper;

import com.slz.project.model.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public interface StudentMapper {
    List<Student> selectList();
}
