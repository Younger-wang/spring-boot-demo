package com.wyg.mydata.repository;

import com.wyg.mydata.vo.DeptJpaVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<DeptJpaVO,String> {
}
