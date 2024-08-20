package com.slz;

import com.slz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        // 输入流读取 Mybatis 配置文件，用于建立连接
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-Config.xml");
        // 通过 Session 工厂构造器构造工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 打开 Session
        SqlSession session = factory.openSession();
        // 执行 sql
        List<Student> list = session.selectList("selectAll"); // 传入 对应 sql id
        // 打印结果
        list.forEach(System.out::println);
        session.close();
    }
}
