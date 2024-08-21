package com.slz.mybatis.util;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class MysqlSession implements SqlSession{
    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return null;
    }

    @Override
    public void close() {

    }
}
