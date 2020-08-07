package com.javatechie.spring.userapplication.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.userapplication.api.model.Department;
import com.javatechie.spring.userapplication.api.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long empId);
    Employee findByEmpName(String empName);
    List<Employee> findByDepartment(Department department);
    
}
