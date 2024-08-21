package com.slz.mybatis.util;

import java.io.InputStream;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath){
        // 通过类加载器后去指定路径资源文件输入流
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
