package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployeeAgeGreaterThan(Integer age);
    List<EmployeeDTO> getEmployeeWithFirstNameAndSalary(String firstName, Integer salary);
}
