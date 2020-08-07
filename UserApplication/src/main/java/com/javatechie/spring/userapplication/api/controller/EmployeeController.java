package com.javatechie.spring.userapplication.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.userapplication.api.model.Department;
import com.javatechie.spring.userapplication.api.model.Employee;
import com.javatechie.spring.userapplication.api.service.EmployeeService;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/saveEmployee")
	public ResponseEntity<List<Employee>> saveEmployee(@RequestBody com.javatechie.spring.userapplication.api.dto.Employee employee )
	{
		try {
		return new ResponseEntity<List<Employee>>(employeeService.saveEmployee(employee),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		try {
		return new ResponseEntity<List<Employee>>(employeeService.lstEmployees(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<List<Employee>> putEmployee(@RequestBody com.javatechie.spring.userapplication.api.dto.Employee employee)
	{
		try {
			return new ResponseEntity<List<Employee>>(employeeService.updateEmployee(employee),HttpStatus.OK);
			}catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
			}
			
	}
	
	@GetMapping("/getEmployee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId)
	{
		try {
		return new ResponseEntity<Employee>(employeeService.getEmployee(empId),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getEmployeeByDeptName/{deptName}")
	public ResponseEntity<List<Employee>> getEmployeesByDeptName(@PathVariable String deptName)
	{
		try 
		{
			
		  return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByDeptName(deptName),HttpStatus.OK);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
	}

}
