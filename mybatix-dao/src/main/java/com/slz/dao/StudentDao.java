package com.slz.dao;

import com.slz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public interface StudentDao {
    default SqlSession getSqlSession() { // 默认手动提交事务
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    default SqlSession getSqlSession(Boolean isAuto) {
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession(isAuto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    int save(Student student);
    int delete(int id);
    int update(Student student);
    List<Student> selectList();
    Student selectId(int id);
}
