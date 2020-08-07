package com.javatechie.spring.userapplication.api.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Entity
@Table(name="Department",schema="usersdb",uniqueConstraints = @UniqueConstraint(columnNames = "deptName"))
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	@Column(name="deptName")
	private String deptName;
	@Column(name="deptDesc")
	private String deptDesc;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", shape=Shape.STRING)
	@Column(name="createdDate")
	private Date createdDate;
	@Column(name="createdBy")
	private String createdBy;

   public Department() {}
	public Department(String deptName) 
	{
		super();
		this.setDeptName(deptName); 
		this.setDeptDesc(deptName);
		this.setCreatedDate(new Date());
		this.setCreatedBy("User");
	}
	
	
}
