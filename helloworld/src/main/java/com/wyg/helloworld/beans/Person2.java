package com.wyg.helloworld.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 需要将bean加入容器中
 * 1、使用@Value() 注解，直接从配置文件中获取属性值
 * 缺点：只能一个个指定属性，且不支持松散绑定，不支持JSR303校验和复杂类型封装
 * 优点：支持EL表达式
 * 使用：业务中获取某个值，使用@Value(),如果是给javaBean注入属性，则使用注解@ConfigurationProperties批量注入
 */
@Component
@Data
public class Person2 {
//    @Value("${customize.person.personName}") // 不支持松散绑定，注不进来会报错
    @Value("${customize.person.person-name}")
    private String personName;
    @Value("#{5*6}")
    private Integer personAge;
    private List<String> personHabitList;
    private Dog personDog;
    private Map<String, String> otherInfo;
    private Date birth;
    private boolean boss;
    private int randomNum;
}
