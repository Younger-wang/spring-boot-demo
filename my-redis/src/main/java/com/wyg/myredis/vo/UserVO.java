package com.wyg.myredis.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private String email;
    private int age;
    private int gender;
    private int dId;
}
