package com.wyg.mydata.repository;

import com.wyg.mydata.vo.DeptJpaVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DeptRepositoryTest {
    @Autowired
    DeptRepository deptRepository;

    @Test
    public void testFindList(){
        List<DeptJpaVO> all = deptRepository.findAll();
        System.out.println(all);
    }
}