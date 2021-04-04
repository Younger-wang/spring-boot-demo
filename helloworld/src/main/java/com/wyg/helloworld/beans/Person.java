package com.wyg.helloworld.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 1、 将配置文件中的每个值，映射到这个组件中
 *      1、@ConfigurationProperties：告诉springboot将本类的所有属性和配置文件中的配置进行绑定；
 *      prefix = "customize.person"：配置文件中的哪个属性进行一一映射
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 * 2、需要配置文件中自动提示，需导入spring-boot-configuration-processor配置文件处理器工具依赖
 */
@Data
@Component
@ConfigurationProperties(prefix = "customize.person")
// 和@Value的区别，支持JSR303校验,SpringBoot 2.3.x 版本后，需引入spring-boot-starter-validation依赖
@Validated
public class Person {
    private String personName;
    private Integer personAge;
    private List<String> personHabitList;
    private Dog personDog;
    private Map<String, String> otherInfo;
    private Date birth;
    private boolean boss;
    private int randomNum;
    @Email(message = "邮箱格式不正确")
    private String personEmail;
}
