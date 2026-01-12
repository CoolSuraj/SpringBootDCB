package com.dcb.SpringBootTutorial.service;

import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

//this annotation to be added to tell Spring boot that this is test class 
@SpringBootTest
class DepartmentServiceTest {



    @Autowired
    private DepartmentService departmentService;

    //this will mock the bean
    @MockitoBean
    private DepartmentRepository departmentRepository;

    //this will be called before each test case
    @BeforeEach
    void setUp() {
        //Builder is used in entity hence we can use like this
        Department department = Department.builder().departmentName("IT")
                .departmentAddress("Pune")
                .departmentCode("IT-01")
                .departmentId(1L)
                .build();
        //here you told service impl should give this response
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    //Writing test case , we ideally should write all the test cases to get full code coverage
    @Test
   public  void whenValidDepartmentName_thenDepartmentNameShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}