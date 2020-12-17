package com.bridgelabz.employeepayrollapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class EmployeeEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", length = 35)
	private String name;
	@Column(name = "IMAGE_PATH")
	private String imagePath;
	@Column(name = "GENDER", length = 10)
	private String gender;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "DEPARTMENT")
	private String department;
	@Column(name = "NOTES")
	private String notes;

}
