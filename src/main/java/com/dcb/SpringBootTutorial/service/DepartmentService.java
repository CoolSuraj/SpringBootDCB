package com.dcb.SpringBootTutorial.service;


import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.error.DepartmentNotFoundException;

import java.util.List;

//Standard Pracrtice to create Interface as one service can have multiple implementations
public interface DepartmentService {

    //Service Method is where all business logic is

   public Department saveDepartment(Department department);

    public List<Department> fetchDeaprtmentList();

    public Department findDepartmentId(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long id);



   public Department updateDeaprtmentById(Long id, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
