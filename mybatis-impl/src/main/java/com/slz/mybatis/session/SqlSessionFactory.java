package com.slz.mybatis.session;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
