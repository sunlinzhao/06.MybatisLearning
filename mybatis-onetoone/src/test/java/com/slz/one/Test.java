package com.slz.one;

import com.slz.one.mapper.DriverInfoMapper;
import com.slz.one.mapper.PersonMapper;
import com.slz.one.model.DriverQuery;
import com.slz.one.model.PersonQuery;
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
//        PersonMapper mapper = session.getMapper(PersonMapper.class);
//        List<PersonQuery> personDrivers = mapper.selectList();
//        personDrivers.forEach(System.out::println);
        DriverInfoMapper mapper = session.getMapper(DriverInfoMapper.class);
        List<DriverQuery> driverQueries = mapper.selectList();
        driverQueries.forEach(System.out::println);
        session.close();
    }
}
