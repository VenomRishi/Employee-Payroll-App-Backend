package com.bridgelabz.employeepayrollapp.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeDTO {
	
	private String name;
	private String imagePath;
	private String gender;
	private int salary;
	private String startDate;
	private String department;
	private String notes;
}
