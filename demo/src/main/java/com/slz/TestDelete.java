package com.slz;

import com.slz.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/20
 */
public class TestDelete {
    public static void main(String[] args) throws IOException {
        SqlSession session = SessionUtil.getSession(true);
        int delete = session.delete("delete", 59);
        session.close();
    }
}
