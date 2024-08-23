package com.slz.mybatis.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */
/*
RetentionPolicy.SOURCE:只保留在源文件，当编译成class文件后，注解被遗弃
RetentionPolicy.CLASS:注解被保到class文华中,jvm加载class文件时被遗弃,默认的生命周期
RetentionPolicy.RUNTIME:不仅被保留在class文件中，jvm加载class文件，仍然存在 (内存中的字节码)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // 标注在方法上
public @interface Select {
    String value();
}
