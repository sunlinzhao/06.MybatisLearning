package com.slz.one.model;

import lombok.Data;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
@Data
public class PersonQuery extends DriverInfo{
    private int pid;
    private String pname;
    private int page;

    @Override
    public String toString() {
        return "PersonDriver{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", page=" + page +
                "} " + super.toString();
    }
}
