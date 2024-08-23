package com.slz.mybatis.util;

import com.slz.mybatis.entity.DbProfile;
import com.slz.mybatis.entity.Mapper;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
@Slf4j(topic = "c.DbUtil")
public class DbUtil {
    public static Connection getConnection(DbProfile profile){
        // 加载驱动
        try {
            Class.forName(profile.getDriver());
            log.debug("load jdbc driver");
            return DriverManager.getConnection(profile.getUrl(), profile.getUsername(), profile.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public <E> List<E> selectList(Mapper mapper, Connection connection){
        List<E> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = mapper.getSqlStatement();
        String className = mapper.getClassName();
        try {
            Class<?> aClass = Class.forName(className);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            log.debug("executeQuery ==> " + sql);
            while (resultSet.next()){
                E obj = (E) aClass.getConstructor().newInstance();
                // 结果集元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                // 获取一共有几个字段
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {

                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    PropertyDescriptor descriptor = new PropertyDescriptor(columnName, aClass);
                    Method writeMethod = descriptor.getWriteMethod();
                    writeMethod.invoke(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(resultSet, statement);
            log.debug("close resultSet & statement");
        }
    }
    private void close(ResultSet resultSet, Statement statement){
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
