package com.slz.mybatis.session.impl;

import com.slz.mybatis.entity.DbProfile;
import com.slz.mybatis.parser.XMLParser;
import com.slz.mybatis.session.SqlSessionFactory;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        try {
            DbProfile profile = XMLParser.parseXml(inputStream);
            return new MysqlSessionFactory(profile);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
