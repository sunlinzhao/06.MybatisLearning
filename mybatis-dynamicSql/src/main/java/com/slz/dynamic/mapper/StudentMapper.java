package com.slz.dynamic.mapper;

import com.slz.dynamic.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */
public interface StudentMapper {
    List<Student> selectCondition(Student student);

    List<Student> selectConditionChoose(Student student);

    List<Student> selectConditionWhere(Student student);

    List<Student> selectConditionTrim(Student student);

    int update(Student student);

    void deleteCheck(int[] ids);

    void deleteCheckOr(int[] ids);

    void deleteCheckList(List<Integer> ids);

    void insertBatch(List<Student> students);

    List<Student> selectByName(Student student);

    List<Student> selectByNameBind(Student student);

    long count();

    //    @Select("<script>" +
//            "select * from student" +
//            "<where>" +
//            "<if test=\"name!=null and name!=''\">" +
//            "and `name` like #{name}" +
//            "</if>" +
//            "<if test=\"age!=null and age!=0\">" +
//            "and age=#{age}" +
//            "</if>" +
//            "</where>" +
//            "</script>")
//    List<Student> selectByAnnotation(Student student);
    @Select({"<script>",
            "select * from student",
            "<where>",
            "<if test=\"name!=null and name!=''\">",
            "and `name` like #{name}",
            "</if>",
            "<if test=\"age!=null and age!=0\">",
            "and age=#{age}",
            "</if>",
            "</where>",
            "</script>"})
    List<Student> selectByAnnotation(Student student);
}
