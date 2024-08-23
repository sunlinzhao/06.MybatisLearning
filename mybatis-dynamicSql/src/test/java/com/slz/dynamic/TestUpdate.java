package com.slz.dynamic;

import com.slz.dynamic.mapper.StudentMapper;
import com.slz.dynamic.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public class TestUpdate {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student(58, "陈心", 88, "女");
        int i = mapper.update(student);
        session.commit();
        session.close();
    }
}
