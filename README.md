# MybatisLearning

# 一、Mybatis 持久层框架

> 学习框架前的预备知识：
>
> - 数据库（mysql、oracle）技术；
> - IDEA 开发工具；
> - Maven 工具；
> - xml 文件；
> - Java 注解 @；

- mybatis 本身是 apache 开源项目 ibatis，2010 年由 apache software foundation 迁移到 google code，并改名为 mybatis；
- 2013 年 11 月迁移到 github；
- mybatis 是开源的**持久层框架**；

#### 1. 与其它持久层框架的对比

- hibernate: 全自动框架，面向对象；
- spring data jpa: 基于hibernate实现；
- mybatis: 半自动框架，专注于sql的编写和优化；
  - 支持定制化sql、存储过程、高级映射；
  - mybatis 避免掉几乎所有 jdbc 的代码；
  - 可以使用简单的 xml 文件或者注解来配置和映射原生信息，将接口和 POJO（Plain Ordinary Java Object,就是 JavaBean 对象） 映射成数据库中的记录；

![image.png](assets/image1.png)

> mybatis 只关注 SQL语句

#### 2. ORM 对象关系映射

持久层框架，也被称作 ORM（Object Relational Mapping） 框架；

> 为什么使用框架？
>
> - 专注于 SQL：开发者可以专注于 SQL 语句的编写，而不是处理诸如连接管理、预编译语句设置等繁琐的任务；
> - 清晰的 SQL 语句：MyBatis 将 SQL 语句与 Java 代码分离，使得 SQL 更加清晰且易于维护；
> - 易于上手和集成：它可以很容易地与 Spring 等其他 Java 框架集成，形成一套完整的开发解决方案；

![image.png](assets/image2.png)

#### 3. Mybatis 功能架构

![image.png](assets/image4.png)

1. 基础支撑层：负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理。将系统共用的抽取出来作为最基础的组件。为上层的数据处理层提供支撑。
2. 数据处理层：负责具体的 sql 查找、sql 解析、sql 执行和执行结果映射处理等。主要目的是根据调用的请求完成一次数据库操作；
3. API 接口层：提供给外部使用的 API，开发人员通过这些 API 来操纵数据库，接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理；

#### 4. Mybatis 工作流程

![image.png](assets/image5.png)

#### 5. Mybatis 入门程序

> Lombok 介绍：
>
> Lombok 是一个 Java 库，它能够帮助开发者减少在 Java 中常见的冗余代码，比如 getter、setter、构造器、equals 和 hashcode 方法等。通过简单的注解，Lombok 能够自动生成这些方法，从而让代码更加简洁和可读。常见的注解包括 `@Getter`、`@Setter`、`@NoArgsConstructor`、`@AllArgsConstructor` 等。
>
> - 简化代码、注解驱动：使用 Lombok 可以显著减少样板代码的数量，使类定义更加简洁，例如，可以通过 `@Data` 注解来自动为类生成 getter、setter、toString、equals 和 hashCode 方法。
> - 即时编译：Lombok 在编译阶段生成所需的代码，因此不会影响运行时的表现。在 IDE 中看不到生成的代码，它们也会在编译后的字节码中出现。
> - 易于集成：集成 Lombok 到项目中通常只需要添加依赖并安装相应的 IDE 插件即可；

###### (1) 环境准备

创建一个 maven 工程；

依赖导入：

- 官网：[Maven Repository: mybatis (mvnrepository.com)](https://mvnrepository.com/search?q=mybatis)或者
- 使用 IDEA 插件 Maven Search

配置 pom.xml 文件：

```xml
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.7</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.22</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.26</version>
    </dependency>
  </dependencies>
  <build>
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
    </resources>
  </build>
```

###### (2) 在 IDEA 中创建配置文件模板

1. config.xml 文件模板

![image.png](assets/image6.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
</configuration>
```

![image.png](assets/image7.png)

3. mapper.xml 文件模板

![image.png](assets/image8.png)

##### (3) config.xml 文件配置

![image.png](assets/image9.png)








++++++++++++++++++++++++++++++
