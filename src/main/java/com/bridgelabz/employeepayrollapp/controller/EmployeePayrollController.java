package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@GetMapping(value = {"/get"})
	public ResponseEntity<List<EmployeeEntity>> getEmployeePayrollData() {
		return new ResponseEntity<>(employeePayrollService.getEmployeeList(), HttpStatus.OK);
	}
	
	@PostMapping(value = {"/add"})
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.addEmployee(employeeDTO), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.deleteEmployee(id) , HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.findEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.updateEmployeeData(id, employeeDTO) , HttpStatus.OK);
	}
}
