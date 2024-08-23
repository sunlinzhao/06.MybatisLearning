package com.slz.dynamic;

import com.slz.dynamic.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public class TestDelete {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
//        int[] ids = {52, 53, 54, 55};
        List<Integer> id_list = Arrays.asList(56, 57);
//        mapper.deleteCheckOr(ids);
        mapper.deleteCheckList(id_list);
        session.commit();
        session.close();
    }
}
