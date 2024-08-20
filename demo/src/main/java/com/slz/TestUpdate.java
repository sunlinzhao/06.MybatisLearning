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
public class TestUpdate {
    public static void main(String[] args) throws IOException {
        SqlSession session = SessionUtil.getSession(true);
        Student student = new Student(51, "张大仙", 25, "女");
        int update = session.update("update", student);
        session.close();
    }
}
