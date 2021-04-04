package com.wyg.helloworld.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 使用@Configuration 配置类注入bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person5 {
    private String personName;
    private Integer personAge;
    private List<String> personHabitList;
    private Dog personDog;
    private Map<String, String> otherInfo;
    private Date birth;
    private boolean boss;
}
