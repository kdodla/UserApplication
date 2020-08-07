package com.javatechie.spring.userapplication.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.spring.userapplication.api.model.Department;
import com.javatechie.spring.userapplication.api.model.Employee;
import com.javatechie.spring.userapplication.api.repository.DepartmentRepository;
import com.javatechie.spring.userapplication.api.repository.EmployeeRepository;
import com.javatechie.spring.userapplication.api.service.EmployeeServiceImpl;
import com.javatechie.spring.userapplication.api.util.ViewMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserApplicationTests 
{
  @Autowired
  private EmployeeServiceImpl empServiceImpl;
  
   @MockBean
  private EmployeeRepository employeeRepository;
   @MockBean
   private DepartmentRepository deptRepository;
   
  @Test
   public void getUsersTest()
   {
	   when(employeeRepository.findAll()).thenReturn(Stream.of(
			   new Employee(1L,"Kalpana",23,230000.0,"F",null,null,null,null,new Department("Finance")),
			   new Employee(2L,"Karuna",23,230000.0,"F",null,null,null,null,new Department("HR"))
			   ).collect(Collectors.toList()));
	   assertEquals(2, empServiceImpl.lstEmployees().size());
   }
 
  // @Test
   public void getEmployeesByDeptNameTest()
   {
	   when(employeeRepository.findByDepartment(new Department("Finance"))).thenReturn(Stream.of(
			   new Employee(1L,"Kalpana",23,230000.0,"F",null,null,null,null,new Department("Finance")))
			   .collect(Collectors.toList()));
	   assertEquals(1, empServiceImpl.getEmployeesByDeptName("Finance").size());
   }
   
   @Test
   public void  saveEmployeeTest()
   {
	   com.javatechie.spring.userapplication.api.dto.Employee emp=new com.javatechie.spring.userapplication.api.dto.Employee("Harshith", 23, 23000.0, "F", "Finance");
	   ViewMapper viewMapper=new ViewMapper();
	  Employee employee= viewMapper.map(emp, Employee.class);
	   when(employeeRepository.save(employee)).thenReturn(employee);
   }
   

}
