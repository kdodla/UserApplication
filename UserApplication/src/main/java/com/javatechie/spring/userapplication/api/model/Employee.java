package com.javatechie.spring.userapplication.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee", schema ="usersdb",
       uniqueConstraints = @UniqueConstraint(columnNames = "empId"))
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@Column(name="empName")
	private String empName;
	@Column(name="empAge")
	private Integer empAge;
	@Column(name="empSalary")
	private Double empSalary;
	@Column(name="empGender")
	private String empGender;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", shape=Shape.STRING)
    @Column(name="createdDate")
	private Date createdDate;
    @Column(name="createdBy")
    private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", shape=Shape.STRING)
    @Column(name="modifiedDate")
    private Date modifiedDate;
    @Column(name="modifiedBy")
    private String modifiedBy;
  
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="emp_dept",
    joinColumns = @JoinColumn(name="emp_id", referencedColumnName = "empId"),
    inverseJoinColumns = @JoinColumn(name="dept_id",referencedColumnName = "deptId"))
    private Department department;
   public Employee() {}
	public Employee(Long empId, String empName, Integer empAge, Double empSalary, String empGender, Date createdDate,
			String createdBy, Date modifiedDate, String modifiedBy, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.empGender = empGender;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.department = department;
	}

	public Employee(Long empId, String empName, Integer empAge, Double empSalary, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.empGender = empGender;
	}
    
    
    
}
