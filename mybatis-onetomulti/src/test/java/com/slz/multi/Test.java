package com.slz.multi;

import com.slz.multi.mapper.TeamMapper;
import com.slz.multi.model.Team;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectList();
        teams.forEach(System.out::println);
        session.close();
    }
}
