package com.slz.one.mapper;

import com.slz.one.model.PersonQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/23
 */
public interface PersonMapper {
    @Select("select * from person p join driverinfo d on p.pid = d.pid")
    List<PersonQuery> selectList();
}
