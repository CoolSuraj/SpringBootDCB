package com.dcb.SpringBootTutorial.controller;

import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //give me object automatically via DI
    @Autowired
    private  DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment( @RequestBody Department department){

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDeaprtmentList();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id")  Long id){
        return  departmentService.findDepartmentId(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")  Long id){
    //it is void method
        departmentService.deleteDepartmentById(id);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}") //this is used for update
    public Department updateDeaprtmentById(@PathVariable("id")  Long departmentId, @RequestBody Department department){

        return departmentService.updateDeaprtmentById(departmentId,department);
    }

    @GetMapping("/departmentByName/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.fetchDepartmentByName(departmentName);
    }

}
