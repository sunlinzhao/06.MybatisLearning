package com.slz.mybatis.entity;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
@Data
public class DbProfile {
    private String driver;
    private String url;
    private String username;
    private String password;
    @Getter
    private Map<String, Mapper> mappers;
    public void setMappers(Map<String, Mapper> mappers){
        if(mappers==null)
            this.mappers=new HashMap<>();
        this.mappers.putAll(mappers);
    }
}
