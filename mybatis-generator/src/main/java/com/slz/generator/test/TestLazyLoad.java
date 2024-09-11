package com.slz.generator.test;

import com.slz.generator.mapper.PlayerMapper;
import com.slz.generator.model.Player;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/10
 */
public class TestLazyLoad {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);
        List<Player> players = mapper.selectList();
        players.forEach((p)->{
            System.out.println(p.getPname()); // 只打印队员姓名，不涉及访问 team 属性
        });
//        players.forEach(System.out::println); // 打印全部属性
        session.close();
    }
}
