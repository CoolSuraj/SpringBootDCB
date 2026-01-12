package com.dcb.SpringBootTutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA annotation
@Entity
//lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id //this is to mark as ID kind of primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) //default is Auto only////
    private Long departmentId;
    private String departmentName;
    private  String departmentAddress;
    private String departmentCode;


}
