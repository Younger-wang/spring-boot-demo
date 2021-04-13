package com.wyg.mydata.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "department_jpa")
public class DeptJpaVO {
    @Id
    private String deptId;
    @Column(name = "dept_name")
    private String deptName;
}
