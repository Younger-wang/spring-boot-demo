package com.wyg.mydata.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeptMapperTest {

    DeptMapper deptMapper;
    @Test
    void findDeptList() {
        System.out.println(deptMapper.findDeptList());
    }

    @Autowired
    private void setDeptMapper(DeptMapper deptMapper){
     this.deptMapper = deptMapper;
    }
}