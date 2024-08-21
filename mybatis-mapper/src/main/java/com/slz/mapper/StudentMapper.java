package com.slz.mapper;

import com.slz.model.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public interface StudentMapper {
    int save(Student student);
    int delete(int id);
    int update(Student student);
    List<Student> selectList();
    Student selectId(int id);
}
