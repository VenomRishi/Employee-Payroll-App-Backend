package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.exception.BadRequestException;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

import com.bridgelabz.employeepayrollapp.exception.NotFoundException;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public ResponseDTO addEmployee(EmployeeDTO employeeDTO) {
    if (employeeDTO == null) {
      throw new BadRequestException("Name is not Proper");
    }
    EmployeeEntity empEntity = new EmployeeEntity();
    empEntity = this.convertEntity(empEntity, employeeDTO);
    empEntity = employeeRepository.save(empEntity);
    if (empEntity != null) {
      return new ResponseDTO("successfully inserted !!!!");
    } else {
      return new ResponseDTO("not success");
    }
  }

  @Override
  public List<EmployeeEntity> getEmployeeList() {
    return employeeRepository.findAll();
  }

  @Override
  public ResponseDTO deleteEmployee(int id) {
    employeeRepository.deleteById(id);
    return new ResponseDTO("Deleted successfully");
  }

  @Override
  public EmployeeEntity findEmployee(int id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("User not found with this Id: " + id));
  }

  @Override
  public EmployeeEntity updateEmployeeData(int employeeId, EmployeeDTO employeeDTO) {
    EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new NotFoundException("User not found with this Id: " + employeeId));
    employeeEntity = this.convertEntity(employeeEntity, employeeDTO);
    employeeEntity.setId(employeeId);
    return employeeRepository.save(employeeEntity);
  }

  private EmployeeDTO convertObj(EmployeeEntity employee) {
    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setName(employee.getName());
    employeeDTO.setGender(employee.getGender());
    employeeDTO.setImagePath(employee.getImagePath());
    employeeDTO.setDepartment(employee.getDepartment());
    employeeDTO.setSalary(employee.getSalary());
    employeeDTO.setNotes(employee.getNotes());
    employeeDTO.setStartDate("");
    return employeeDTO;
  }

  private EmployeeEntity convertEntity(EmployeeEntity empEntity, EmployeeDTO empDo) {
    empEntity.setName(empDo.getName());
    empEntity.setDepartment(empDo.getDepartment());
    empEntity.setGender(empDo.getGender());
    empEntity.setImagePath(empDo.getImagePath());
    empEntity.setSalary(empDo.getSalary());
    empEntity.setNotes(empDo.getNotes());
    empEntity.setStartDate(new Date());
    return empEntity;
  }

}
