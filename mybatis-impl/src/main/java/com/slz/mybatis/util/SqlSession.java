package com.slz.mybatis.util;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public interface SqlSession {
    // 泛型放在方法上，是方法级别的泛型
    <T> T getMapper(Class<T> mapperClass);
    void close();
}
