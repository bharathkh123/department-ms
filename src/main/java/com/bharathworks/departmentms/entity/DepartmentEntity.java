package com.bharathworks.departmentms.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
@Data
public class DepartmentEntity {

    @Id
    @Column(name="ID")
    private Long departmentId;
    @Column(name="NAME")
    private String departmentName;

}
