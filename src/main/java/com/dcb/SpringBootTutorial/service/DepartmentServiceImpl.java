package com.dcb.SpringBootTutorial.service;

import com.dcb.SpringBootTutorial.entity.Department;
import com.dcb.SpringBootTutorial.error.DepartmentNotFoundException;
import com.dcb.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        //JPA Repository gives all the methods for JPA
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDeaprtmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentId(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
          throw new DepartmentNotFoundException("Department Id Not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {

        departmentRepository.deleteById(id);
    }


    @Override
    public Department updateDeaprtmentById(Long id, Department department) {
        Optional<Department> department1 = departmentRepository.findById(id);
        if (department1.isPresent()) {

            if (StringUtils.hasText(department.getDepartmentName())) {
                department1.get().setDepartmentName(department.getDepartmentName());
            }
            if (StringUtils.hasText(department.getDepartmentAddress())) {
                department1.get().setDepartmentAddress(department.getDepartmentAddress());
            }
            if (StringUtils.hasText(department.getDepartmentCode())) {
                department1.get().setDepartmentCode(department.getDepartmentCode());
            }
            return departmentRepository.save(department1.get());

        } else {
            return null;
        }
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
