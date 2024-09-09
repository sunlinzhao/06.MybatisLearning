package com.slz.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfo {
    private int did;
    private String dtype;
    private int pid;
}
