package com.slz.mybatis.util;

import com.slz.mybatis.entity.Mapper;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */
@AllArgsConstructor
public class ProxyImpl implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection connection;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName(); // selectList
        String className = method.getDeclaringClass().getName(); // Student
        // xxx.xx.Student.selectList
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if(mapper==null){
            throw new RuntimeException("StatementId is not registry");
        }
        return new DbUtil().selectList(mapper, connection);
    }
}
