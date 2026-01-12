package com.dcb.SpringBootTutorial.repository;
//
//import com.dcb.SpringBootTutorial.entity.Department;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//// Fixed Imports
//import org.springframework.boot.test.autoconfigure.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.jpa.TestEntityManager;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
class DepartmentRepositoryTest {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    private Long savedId;
//
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .departmentName("InfoT")
//                .departmentAddress("Kolkata")
//                .departmentCode("IT-06")
//                // REMOVE .departmentId(3L) - let the DB handle it
//                .build();
//
//        // persist returns the entity after it has been assigned an ID by the DB
//        Department savedDepartment = entityManager.persist(department);
//        this.savedId = savedDepartment.getDepartmentId();
//    }
//
//    @Test
//    public void whenFindByID_thenReturnDepartment() {
//        // Use the ID assigned by the database, not a hardcoded
//        Department department = departmentRepository.findById(savedId).get();
//        assertEquals("InfoT", department.getDepartmentName());
//    }
}