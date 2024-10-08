package com.slz.mybatis.parser;

import com.slz.mybatis.entity.DbProfile;
import com.slz.mybatis.entity.Mapper;
import com.slz.mybatis.util.Resources;
import com.slz.mybatis.util.Select;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/21
 */
public class XMLParser {
    public static DbProfile parseXml(InputStream inputStream) throws DocumentException {
        // 最后返回的封装类
        DbProfile profile = new DbProfile();
        // 使用 dom4j 读取 xml 文件，进行解析
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> properties = root.selectNodes("//property");
        for (Element property : properties) {
            if ("driver".equals(property.attributeValue("name")))
                profile.setDriver(property.attributeValue("value"));
            if ("url".equals(property.attributeValue("name")))
                profile.setUrl(property.attributeValue("value"));
            if ("username".equals(property.attributeValue("name")))
                profile.setUsername(property.attributeValue("value"));
            if ("password".equals(property.attributeValue("name")))
                profile.setPassword(property.attributeValue("value"));
        }
        // 读取 mappers 资源
        List<Element> mappers = root.selectNodes("//mappers/mapper");
        for (Element mapper : mappers) {
            String resourcePath = mapper.attributeValue("resource");
            if (resourcePath != null){ // 读取xml
                Map<String, Mapper> temps = getMapper(resourcePath); // 读取对应 mapper.xml 文件
                profile.setMappers(temps);
            } else { // 读取 class
                String classPath = mapper.attributeValue("class");
                Map<String, Mapper> temps = getMapperAnnotations(classPath);

                profile.setMappers(temps);
            }
        }
        return profile;
    }
    private static Map<String, Mapper> getMapperAnnotations(String classPath){
        // com.slz.project.mapper.StudentDao
        Map<String, Mapper> mappers = new HashMap<>();
        try {
            Class<?> aClass = Class.forName(classPath);
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                boolean annotationPresent = method.isAnnotationPresent(Select.class); // 是否被是 Select 注解
                if(annotationPresent){
                    Mapper mapper = new Mapper();
                    Select select = method.getAnnotation(Select.class);
                    String sql = select.value();
                    Type genericReturnType = method.getGenericReturnType(); // 获取当前方法返回类型的泛型
                    if(genericReturnType instanceof ParameterizedType){ // 判断是不是参数化类型（泛型）
                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                        // 获取运行时的实际泛型类型
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Class actualTypeArgument = (Class) actualTypeArguments[0];
                        String name = actualTypeArgument.getName();

                        mapper.setClassName(name).setSqlStatement(sql);
                    }
                    String key = method.getDeclaringClass().getName() + "." + method.getName();
                    mappers.put(key, mapper);
                }
            }
            return mappers;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Map<String, Mapper> getMapper(String path) throws DocumentException {
        Map<String, Mapper> mappers = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream resourceAsStream = Resources.getResourceAsStream(path);
        Document document = reader.read(resourceAsStream);
        Element root = document.getRootElement();
        // 获取命名空间
        String namespace = root.attributeValue("namespace");
        List<Element> list = root.selectNodes("//select");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String sql = element.getText(); // 获取文本
            // 封装对象
            Mapper mapper = new Mapper();
            mapper.setClassName(resultType).setSqlStatement(sql);
            String key = namespace + "." + id;
            mappers.put(key, mapper);
        }
        return mappers;
    }
}
