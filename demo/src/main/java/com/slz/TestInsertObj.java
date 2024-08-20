package com.slz;

import com.slz.model.Student;
import com.slz.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/20
 */
public class TestInsertObj {
    public static void main(String[] args) throws IOException {
        SqlSession session = SessionUtil.getSession(true);
        Student student = new Student();
        Student student1 = student.setName("陈维").setAge(25).setGender("男");
//        int insertObject = session.insert("insertObject", student1); // #
//        int insertObject = session.insert("insertObject1", student1); // $
        int insertObject = session.insert("insertAndGetId", student1); // getId
        System.out.println(insertObject>0 ? "y" : "n");
        System.out.println(student1.getId());
        session.close();
    }
}
