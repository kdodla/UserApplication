package com.javatechie.spring.userapplication.api.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.userapplication.api.model.Department;
import com.javatechie.spring.userapplication.api.model.Employee;
import com.javatechie.spring.userapplication.api.repository.DepartmentRepository;
import com.javatechie.spring.userapplication.api.repository.EmployeeRepository;
import com.javatechie.spring.userapplication.api.util.ViewMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	@Autowired
	private DepartmentRepository deptRepository;
	@Autowired
	private ViewMapper viewMapper;
	
	
	public List<Employee> saveEmployee(com.javatechie.spring.userapplication.api.dto.Employee employee)
	{
		
		 try {
			    Employee emp=viewMapper.map(employee, Employee.class);
		        emp.setCreatedBy("User");
			    emp.setCreatedDate(new Date());
			    emp.setDepartment(createDepartmentIfNotFound(employee.getDepartment()) );
			    empRepository.save(emp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return empRepository.findAll();
	}
	 @Transactional
	 Department createDepartmentIfNotFound(String name) 
		 {
		 
	      Department dept = deptRepository.findByDeptName(name);
	        if (dept == null) {
	        	dept = new Department(name);
	        	System.out.println(dept.toString());
	        	dept= deptRepository.save(dept);
	        }
	        return dept;
		    }

	@Override
	public List<Employee> lstEmployees() {
		// TODO Auto-generated method stub
	  	List<Employee> lstEmployees=empRepository.findAll();
	  	System.out.println("Getting data from DB===>> "+lstEmployees);
		return lstEmployees;
	}
   @Override
	public Employee getEmployee(Long empId)
	{
		return empRepository.findByEmpId(empId);
	}
	@Override
	public List<Employee> getEmployeesByDeptName(String deptName) {
		// TODO Auto-generated method stub
		 Department dept = deptRepository.findByDeptName(deptName);
		 if(dept==null)
			 return new ArrayList<Employee>();
		return empRepository.findByDepartment(dept);
	}

	public  List<Employee> updateEmployee(com.javatechie.spring.userapplication.api.dto.Employee employee) {
		List<Employee> lstEmployee=null;
		Employee emp=empRepository.findByEmpName(employee.getEmpName());
		if(emp==null)
		{
	        lstEmployee=saveEmployee(employee);
		}
		else
		{
		    emp.setEmpAge(employee.getEmpAge());
		    emp.setEmpGender(employee.getEmpGender());
		    emp.setEmpSalary(employee.getEmpSalary());
		    emp.setModifiedDate(new Date());
		    emp.setModifiedBy("User");
		    emp.setDepartment(createDepartmentIfNotFound(employee.getDepartment()));
		    emp=empRepository.save(emp);
		    lstEmployee=new ArrayList<Employee>();
		    lstEmployee.add(emp);
		}
		return lstEmployee;
	}

}
