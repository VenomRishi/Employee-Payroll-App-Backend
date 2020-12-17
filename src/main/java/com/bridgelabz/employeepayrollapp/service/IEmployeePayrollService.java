package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

public interface IEmployeePayrollService {
	
	public ResponseDTO addEmployee(EmployeeDTO employeeDTO);
	public List<EmployeeEntity> getEmployeeList();
	public ResponseDTO deleteEmployee(int id);
	public EmployeeEntity findEmployee(int id);
	public EmployeeEntity updateEmployeeData(int employeeId, EmployeeDTO employeeDTO);
}
