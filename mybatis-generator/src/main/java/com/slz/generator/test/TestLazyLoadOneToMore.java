package com.slz.generator.test;

import com.slz.generator.mapper.TeamMapper;
import com.slz.generator.model.Team;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/11
 */
public class TestLazyLoadOneToMore {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectList();
//        teams.forEach(System.out::println);
        teams.forEach((t)->{
            System.out.println(t.getTname());
        });
        session.close();
    }
}
