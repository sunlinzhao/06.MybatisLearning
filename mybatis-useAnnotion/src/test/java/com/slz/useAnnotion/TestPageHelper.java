package com.slz.useAnnotion;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.slz.useAnnotion.mapper.StudentMapper;
import com.slz.useAnnotion.model.Student;
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
public class TestPageHelper {
    public static void main(String[] args) throws IOException {
        // 拿到 Session
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-Config.xml")).openSession();
        // 拿到 mapper
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        // 配置分页规则，这里获取第2分页，每页有3条数据\
        // 计算规则
        // limit x, z
        // z=pageSize
        // x = (pageNum -1)*z
        PageHelper.startPage(2, 3);
        // 查询数据
        List<Student> students = mapper.selectList();
        // 将从查询结果封装到 PageInfo 做分页处理
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        // 通过 PageInfo 对象获取到 当前分页信息
        List<Student> list = pageInfo.getList();
        // 打印当前分页
        list.forEach(System.out::println);
        session.close();
    }
}
