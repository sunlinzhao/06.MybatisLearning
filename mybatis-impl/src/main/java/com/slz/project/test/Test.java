package com.slz.project.test;

import com.slz.mybatis.session.SqlSession;
import com.slz.mybatis.session.impl.SqlSessionFactoryBuilder;
import com.slz.mybatis.util.Resources;
import com.slz.project.mapper.StudentMapper;
import com.slz.project.model.Student;

import java.io.InputStream;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class Test {
    public static void main(String[] args) {
        // 获取资源配置文件 mybatis-config.xml 的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectList();
        students.forEach(System.out::println);
    }
}
