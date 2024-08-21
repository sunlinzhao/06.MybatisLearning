package com.slz.mybatis.util;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class MysqlSessionFactory implements SqlSessionFactory{
    @Override
    public SqlSession openSession() {
        return new MysqlSession();
    }
}
