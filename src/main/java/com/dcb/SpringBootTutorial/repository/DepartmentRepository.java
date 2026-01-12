package com.dcb.SpringBootTutorial.repository;

import com.dcb.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Marking this as Repository
@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Long> {
//extending with JPArepository gives us all the methods needed for DB Operations
    //just need to follow conventions https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    public Department findByDepartmentName(String departmentName);
}
