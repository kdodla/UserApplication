package com.javatechie.spring.userapplication.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private String empName;

	private Integer empAge;

	private Double empSalary;
	
	private String empGender;
	
	private String Department;
 
}
