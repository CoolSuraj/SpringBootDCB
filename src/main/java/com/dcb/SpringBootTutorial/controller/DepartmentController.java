package com.dcb.SpringBootTutorial.controller;

import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.error.DepartmentNotFoundException;
import com.dcb.SpringBootTutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //By Default Spring gives This Slf4j Logger to use, we can add log4j or other if needed
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    //give me object automatically via DI
    @Autowired
    private  DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment( @Valid  @RequestBody Department department){
        logger.info(" Request Received for saveDepartment  {}", department.toString());
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDeaprtmentList();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id")  Long id) throws DepartmentNotFoundException {
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
