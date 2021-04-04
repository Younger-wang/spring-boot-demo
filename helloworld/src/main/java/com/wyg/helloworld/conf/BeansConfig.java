package com.wyg.helloworld.conf;

import com.wyg.helloworld.beans.Dog;
import com.wyg.helloworld.beans.Person5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * 1、@Configuration 指明当前类为配置类，用来替代spring的配置文件
 */
@Configuration
public class BeansConfig {

    @Bean
    // 等价于配置文件中的<bean></bean>标签添加组件
    // 将方法的返回值添加到容器中，默认的容器beanName为方法名称
    public Person5 person5(){
        String personName = "光头强";
        int age = 24;
        List<String> personHabitList = Arrays.asList("滑雪","篮球");
        Dog dog = new Dog("二哈", 3);
        Map<String, String> otherInfo = new HashMap<>();
        otherInfo.put("addr","高新区");
        otherInfo.put("work","docker");
        Date birth = new Date();
        return new Person5(personName, age, personHabitList, dog, otherInfo, birth, true);
    }
}
