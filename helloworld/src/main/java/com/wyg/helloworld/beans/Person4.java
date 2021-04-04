package com.wyg.helloworld.beans;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 使用@ImportResource 导入spring配置文件的方式注入bean，这里不需要将bean加入容器中
 * 1、使用@ImportResource 导入spring的配置文件
 */
@Data
public class Person4 {
    private String personName;
    private Integer personAge;
    private List<String> personHabitList;
    private Dog personDog;
    private Map<String, String> otherInfo;
    private Date birth;
    private boolean boss;
}
