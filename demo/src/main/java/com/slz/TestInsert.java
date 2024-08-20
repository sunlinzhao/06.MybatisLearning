package com.slz;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/20
 */
public class TestInsert {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-Config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession session = build.openSession(); // 这里自动提交，默认是关闭的，所以需要手动提交
        int insert = session.insert("insert");
        System.out.println(insert > 0 ? "成功" : "失败");
        session.commit(); // 查询对原来数据没有影响不需要提交事务，但是插入不是
        session.close();
    }
}
