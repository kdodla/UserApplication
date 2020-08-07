package com.javatechie.spring.userapplication.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.userapplication.api.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


	Department findByDeptName(String deptName);
	
	Department findByDeptId(Long deptId);
		
}
