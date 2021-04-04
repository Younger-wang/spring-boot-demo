package com.wyg.helloworld.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 先将bean注入容器中
 * 1、使用@PropertySource,加载指定的配置文件直接绑定对应的属性
 * 需要配合@ConfigurationProperties注解使用，prefix为properties文件中的前缀
 */
@Component
@ConfigurationProperties(prefix = "personiii")
@Data
@PropertySource(value = "classpath:properties/personIII.properties", encoding = "UTF-8")
public class Person3 {
    private String personName;
    private Integer personAge;
    private List<String> personHabitList;
    private Dog personDog;
    private Map<String, String> otherInfo;
    private Date birth;
    private boolean boss;
}
