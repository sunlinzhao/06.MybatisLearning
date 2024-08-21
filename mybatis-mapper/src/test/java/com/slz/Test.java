package com.slz;

import com.slz.mapper.StudentMapper;
import com.slz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        // 自动生成当前接口的代理实现类
        StudentMapper studentMapper = session.getMapper(StudentMapper.class); // 接口，实现类由 mybatis 代理
        List<Student> list = studentMapper.selectList();
        list.forEach(System.out::println);
        session.close();
    }
}
