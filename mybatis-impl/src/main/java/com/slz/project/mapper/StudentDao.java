package com.slz.project.mapper;

import com.slz.mybatis.util.Select;
import com.slz.project.model.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */


public interface StudentDao {
    @Select("select * from student")
    List<Student> selectList();
}
