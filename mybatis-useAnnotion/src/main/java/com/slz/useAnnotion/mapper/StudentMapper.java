package com.slz.useAnnotion.mapper;

import com.slz.useAnnotion.model.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/11
 */
public interface StudentMapper {
    @Results(id="r", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "sname"),
            @Result(column = "age", property = "age"),
            @Result(column = "gender", property = "gender"),
    })
    @Select("select * from student")
    List<Student> selectList();

    @ResultMap(value = {"r"})
    @Select("select * from student")
    List<Student> selectAll();
}
