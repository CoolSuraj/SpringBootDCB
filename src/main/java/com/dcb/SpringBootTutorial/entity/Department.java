package com.dcb.SpringBootTutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
* 1. The Hierarchy (JPA vs. Hibernate vs. Spring Data)

People often use these terms interchangeably, but they are different layers of the same stack:

    JPA (Java Persistence API): This is a specification (a set of rules/interfaces).
    * It defines how an ORM should behave but doesn't do any work itself.

Hibernate: This is the implementation.
* It is the actual library that takes your Java objects and converts them into SQL.
* It is the default implementation used by Spring Boot.

Spring Data JPA: This is a wrapper provided by Spring.
* It sits on top of Hibernate to make your life even easier by providing Repositories
* (like JpaRepository) so you don't even have to write Hibernate code.

* */
//JPA annotation
@Entity
//lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id //this is to mark as ID kind of primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) //default is Auto only////
    private Long departmentId;

    ///Hibernate validation
    /// //this validation insures that no matter what you have to give this key while saving
    /// but @Valid needs to be added at Controller
    /// message is something will print in as defaultMessage in Exception sent back(if not handlled gracefully)
    @NotBlank(message = "Department Name should not be empty")
    private String departmentName;

    /**
     * There are other validations available some given below
     * @Length,
     * @Size
     * @Email
     * @Positive, @Negative
     * @Future // Date
     * @FutureOrPresent //Date
     */
    private  String departmentAddress;
    private String departmentCode;


}
