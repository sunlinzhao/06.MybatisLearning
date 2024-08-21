package com.slz.mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */

@Data
@Accessors(chain = true)
public class Mapper {
    // 封装 mapper.xml 文件中的 SQL 语句
    private String sqlStatement;
    // 封装 mapper.xml 中的返回值类型
    private String className;
}
