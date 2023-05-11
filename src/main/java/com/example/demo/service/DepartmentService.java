package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO;
import com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO;
import com.example.demo.entity.Department;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO findDepartmentById(Long deptid);
    List<DepartmentDTO> findByName(String departmentName);
    List<DepartmentDTO> findByNameIsNull();
    List<DepartmentDTO> findByNameNot(String departmentName);
    List<DepartmentDTO>  findByNameAndStartDate(String departmentName, LocalDate startDate);
    List<DepartmentDTO> findByStartDate(LocalDate startDate);
    List<DepartmentDTO> findByStartDateBetween(LocalDate date1, LocalDate date2);
    List<DepartmentDTO> findByOrderByStartDateAsc();
    Department createDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(Long deptid);
    Department updateDepartment(Long deptid, DepartmentDTO departmentDTO);
    List<DepartmentWithNumberOfEmployeesDTO> getNumberOfEmployeesInDepartments();
    List<DepartmentDTO> getDepartmentByDepartmentNameOrStartDate(String name, LocalDate startDate);
    List<DepartmentOfEmployeeWithMaxSalaryDTO> getEmployeeWithMaxSalary();

}
