package com.slz.util;

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
public class SessionUtil {
    public static SqlSession getSession(Boolean isAutoCommit) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-Config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession session = build.openSession(isAutoCommit); // 这里设置事务是否自动提交，默认是关闭的,true 是开启自动提交
        return session;
    }
}
