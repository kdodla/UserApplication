package com.javatechie.spring.userapplication.api.service;

import java.util.List;

import com.javatechie.spring.userapplication.api.model.Employee;

public interface EmployeeService {

	public List<Employee> lstEmployees();
    
	public List<Employee> saveEmployee(com.javatechie.spring.userapplication.api.dto.Employee employee);
	
	public Employee getEmployee(Long empId);
	
	public List<Employee> getEmployeesByDeptName(String deptName);
	
	public  List<Employee> updateEmployee(com.javatechie.spring.userapplication.api.dto.Employee employee);
}
