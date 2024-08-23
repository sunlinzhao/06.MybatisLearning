package com.slz.dynamic;

import com.slz.dynamic.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public class TestCount {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        long count = mapper.count();
        System.out.println(count);
        session.close();
    }
}
