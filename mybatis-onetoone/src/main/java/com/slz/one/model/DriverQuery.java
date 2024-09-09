package com.slz.one.model;

import lombok.Data;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/9/9
 */
@Data
public class DriverQuery extends DriverInfo{
    private Person person;

    @Override
    public String toString() {
        return "DriverQuery{" +
                "person=" + person +
                "} " + super.toString();
    }
}
