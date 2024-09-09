package com.slz.generator.test;

import com.slz.generator.mapper.StudentMapper;
import com.slz.generator.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
public class TestCache {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(Resources.getResourceAsStream("Mybatis-Config.xml"));
        SqlSession session = build.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByExample(null);
        students.forEach(System.out::println);
        session.close();

        System.out.println("-----------------------------------");

        // 再次查询打印
        session = build.openSession();
        mapper = session.getMapper(StudentMapper.class);
        students = mapper.selectByExample(null);
        students.forEach(System.out::println);
        session.close();

        System.out.println("-----------------------------------");

        // 再次查询打印
        session = build.openSession();
        mapper = session.getMapper(StudentMapper.class);
        students = mapper.selectByExample(null);
        students.forEach(System.out::println);
        session.close();
    }
}
