package com.wyg.myjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/findDepartment")
    public List<Map<String, Object>> getDepartment() {
        return jdbcTemplate.queryForList("select * from department");
    }
}
