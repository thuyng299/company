package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> findEmployeeById(String employeeId){
        return employeeRepository.findById(employeeId);
    }
    public List<Employee> findByLastNameOrFirstName(String lastName, String firstName){
        return employeeRepository.findByLastNameOrFirstName(lastName, firstName);
    }
    public List<Employee> findByFirstNameLike(String firstName){
        return employeeRepository.findByFirstNameLike(firstName);
    }
    public List<Employee> findByLastNameNot(String lastName){
        return employeeRepository.findByLastNameNot(lastName);
    }
    public List<Employee> findByOrderBySalary(){
        return employeeRepository.findByOrderBySalary();
    }
    public List<Employee> findByDateOfBirthAfter(LocalDate date){
        return employeeRepository.findByDateOfBirthAfter(date);
    }

    public Employee createEmployee(EmployeeDTO employeeDTO, Long deptid){
        Optional<Department> department = departmentRepository.findById(deptid);

        Employee employee = new Employee();
        employee.setEmployeeID(employeeDTO.getEmployeeID());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setGender(employeeDTO.getGender());
        employee.setLastName(employeeDTO.getLastName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setSalary(employeeDTO.getSalary());
        if (department.isPresent())
            employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(String employeeId){
        employeeRepository.deleteById(employeeId);
    }
    public Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee updateEmployee = employee.get();
        updateEmployee.setEmployeeID(employeeDTO.getEmployeeID());
        updateEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        updateEmployee.setFirstName(employeeDTO.getFirstName());
        updateEmployee.setGender(employeeDTO.getGender());
        updateEmployee.setLastName(employeeDTO.getLastName());
        updateEmployee.setMiddleName(employeeDTO.getMiddleName());
        updateEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(updateEmployee);
    }

}
