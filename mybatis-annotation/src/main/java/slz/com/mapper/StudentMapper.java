package slz.com.mapper;

import org.apache.ibatis.annotations.*;
import slz.com.model.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/22
 */

public interface StudentMapper {
    @Insert("intser into student values(default, #{name}, #{age}, #{gender})")
    int save(Student student);
    @Delete("delete from student where id=#{id}")
    int delete(int id);
    @Update("update student set `name`=#{name}, age=#{age}, gender=#{gender} where id=#{id}")
    int update(Student student);
    @Select("select * from student order by age")
    List<Student> selectList();
    @Select("select * from student where id=#{id}")
    Student selectById(int id);
}
