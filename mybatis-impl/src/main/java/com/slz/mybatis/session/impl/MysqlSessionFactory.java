package com.slz.mybatis.session.impl;

import com.slz.mybatis.entity.DbProfile;
import com.slz.mybatis.session.SqlSession;
import com.slz.mybatis.session.SqlSessionFactory;
import lombok.AllArgsConstructor;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */

@AllArgsConstructor // 全参数构造函数
public class MysqlSessionFactory implements SqlSessionFactory {
    private DbProfile profile;
    @Override
    public SqlSession openSession() {
        return new MysqlSession(profile);
    }
}
