package com.wyg.myredis.controller;

import com.wyg.myredis.mapper.UserMapper;
import com.wyg.myredis.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@CacheConfig(cacheManager = "userCacheManager")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    @Cacheable(value = "getUserById")
    public UserVO getUserById(@PathVariable("id") int id) throws Exception {
        System.out.println("UserController.getUserById...");
        return userMapper.getUserById(id);
    }

    @PostMapping("/user")
    public boolean insertUser(UserVO userVO) throws Exception {
        System.out.println("UserController.insertUser...");
        return userMapper.insertUser(userVO) > 0;
    }

    @PutMapping("/user")
    public boolean updateUser(UserVO userVO) throws Exception {
        System.out.println("UserController.updateUser...");
        return userMapper.updateUser(userVO) > 0;
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") int id) throws Exception {
        System.out.println("UserController.deleteUser...");
        return userMapper.delete(id) > 0;
    }
}
