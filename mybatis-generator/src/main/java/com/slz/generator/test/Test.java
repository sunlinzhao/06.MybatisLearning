package com.slz.generator.test;

import com.slz.generator.mapper.StudentMapper;
import com.slz.generator.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectByPrimaryKey(47);
        System.out.println(student.toString());
        session.close();
    }
}
