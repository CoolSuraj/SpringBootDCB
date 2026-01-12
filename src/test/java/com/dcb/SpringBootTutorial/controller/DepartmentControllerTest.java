package com.dcb.SpringBootTutorial.controller;

import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        Department department = Department.builder()
                .departmentName("InfoT")
                .departmentAddress("Kolkata")
                .departmentCode("IT-06")
              .departmentId(1L)
                .build();
    }

    @Test
    public void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("InfoT")
                .departmentAddress("Kolkata")
                .departmentCode("IT-06")
                 .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/saveDepartment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"InfoT\",\n" +
                        "    \"departmentAddress\": \"Kolkata\",\n" +
                        "    \"departmentCode\":\"IT-06\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }


    @Test
    public void findDepartmentById() {

    }
}