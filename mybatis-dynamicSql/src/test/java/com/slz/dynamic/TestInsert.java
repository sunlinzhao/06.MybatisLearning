package com.slz.dynamic;

import com.slz.dynamic.mapper.StudentMapper;
import com.slz.dynamic.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public class TestInsert {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Student(0, "孙悟空", i+20, "男"));
        }
        mapper.insertBatch(list);
        session.commit();
        session.close();
    }
}
