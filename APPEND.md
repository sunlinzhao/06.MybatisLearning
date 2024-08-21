# 手动编写 mybatis 功能

## 1. 准备工作

![image.png](assets/image25.png?t=1724243772202)

### (1) 工程 pom.xml 文件处理

> 引入 xml 文件和 xpath 解析的依赖，将 mybatis 作用范围限制在测试阶段

```xml
  <dependencies>
<!--    解析xml文件-->
    <dependency>
      <groupId>dom4j</groupId>
      <artifactId>dom4j</artifactId>
      <version>1.6.1</version>
    </dependency>
<!--    解析xpath-->
    <dependency>
      <groupId>jaxen</groupId>
      <artifactId>jaxen</artifactId>
      <version>1.2.0</version>
    </dependency>
<!--    取消从父工程引入的 mybatis / 将 mybatis 作用范围限制在测试阶段-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.7</version>
      <scope>test</scope> <!--测试范围-->
    </dependency>
    <!--  其它依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.26</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.22</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```

### (2) 创建模型层

```java
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
}
```

### (3) 创建一个 Mapper 接口

```java
public interface StudentMapper {
    List<Student> selectList();
}
```

### (4) 创建一个 Mapper.xml 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<mapper namespace="com.slz.mybatis.mapper.StudentMapper">
    <select id="selectList" resultType="com.slz.mybatis.model.Student">
        select * from student
    </select>
</mapper>
```

### (5) 创建 mybatis-config.xml 全局配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <environments default="dev">
        <environment id="dev">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <!--& 相当于一个 & ，这里需要采用此方法来转义-->
                <property name="url" value="jdbc:mysql://8.130.102.188:3306/Mybatis?rewriteBatchStatements=true&serverTimeZone=GMT%2B8&useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/slz/mybatis/mapper/StudentMapper.xml"></mapper>
    </mappers>
</configuration>
```

## 2. 具体实现

+++++++++++++++++++++++++++
