package com.slz.dao.impl;

import com.slz.dao.StudentDao;
import com.slz.model.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public int save(Student student) {
        SqlSession session = getSqlSession();
        int i = session.insert("save", student);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public int delete(int id) {
        SqlSession session = getSqlSession();
        int i = session.delete("delete", id);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public int update(Student student) {
        SqlSession session = getSqlSession();
        int i = session.update("update", student);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public List<Student> selectList() {  // 查询不需要 commit Tx
        SqlSession session = getSqlSession();
        List<Student> selectList = session.selectList("selectList");
        session.close();
        return selectList;
    }

    @Override
    public Student selectId(int id) {
        SqlSession session = getSqlSession();
        Student selectId = session.selectOne("selectId", id);
        session.close();
        return selectId;
    }
}
