package com.slz.mybatis.session.impl;

import com.slz.mybatis.entity.DbProfile;
import com.slz.mybatis.session.SqlSession;
import com.slz.mybatis.util.DbUtil;
import com.slz.mybatis.util.ProxyImpl;
import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
@AllArgsConstructor
public class MysqlSession implements SqlSession {
    private DbProfile profile;
    private Connection connection;

    public MysqlSession(DbProfile profile) {
        this.profile = profile;
        connection = DbUtil.getConnection(profile);
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass},
                new ProxyImpl(profile.getMappers(), connection));
    }

    @Override
    public void close() {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
