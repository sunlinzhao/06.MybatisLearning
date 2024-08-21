package com.slz;

import com.slz.dao.StudentDao;
import com.slz.dao.impl.StudentDaoImpl;
import com.slz.model.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class TestDao {
    public static void main(String[] args) {
        List<Student> list = list();
        list.forEach(System.out::println);
    }
    public static List<Student> list(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.selectList();
        return list;
    }
}
