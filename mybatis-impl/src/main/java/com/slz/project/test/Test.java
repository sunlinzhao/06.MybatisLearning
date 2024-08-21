package com.slz.project.test;

import com.slz.mybatis.util.Resources;

import java.io.InputStream;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class Test {
    public static void main(String[] args) {
        // 获取资源配置文件 mybatis-config.xml 的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

    }
}
