package com.wyg.mydata.controller;

import com.wyg.mydata.mapper.DeptMapper;
import com.wyg.mydata.repository.DeptRepository;
import com.wyg.mydata.vo.DeptJpaVO;
import com.wyg.mydata.vo.DeptVO;
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

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptRepository deptRepository;

    @GetMapping("/findDepartment")
    public List<Map<String, Object>> getDepartment() {
        return jdbcTemplate.queryForList("select * from department");
    }

    @GetMapping("/getDeptListInMybatis")
    public List<DeptVO> getDeptListInMybatis() {
        return deptMapper.findDeptList();
    }

    @GetMapping("/getDeptListInJpa")
    public List<DeptJpaVO> getDeptListInJpa() {
        return deptRepository.findAll();
    }
}
