package com.example.demo.rest;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResponseException;
import com.example.demo.serviceimpl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.lang.module.ResolutionException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI{
    private final EmployeeServiceImpl employeeServiceImpl;

    @Override
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeServiceImpl.getAllEmployee());
    }
    @Override
    public ResponseEntity<Optional<Employee>> findEmployeeById(String employeeID){
        return ResponseEntity.ok(employeeServiceImpl.findEmployeeById(employeeID));
    }
    @Override
    public ResponseEntity<List<Employee>> findByLastNameOrFirstName(String lastName, String firstName){
        return ResponseEntity.ok(employeeServiceImpl.findByLastNameOrFirstName(lastName,firstName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByFirstNameLike(String firstName){
        return ResponseEntity.ok(employeeServiceImpl.findByFirstNameLike(firstName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByLastNameNot(String lastName){
        return ResponseEntity.ok(employeeServiceImpl.findByLastNameNot(lastName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByOrderBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.findByOrderBySalary());
    }
    @Override
    public ResponseEntity<List<Employee>> findByDateOfBirthAfter(LocalDate date){
        return ResponseEntity.ok(employeeServiceImpl.findByDateOfBirthAfter(date));
    }
    @Override
    public ResponseEntity<Employee> createEmployee(Long deptid,EmployeeDTO employeeDTO){
        Employee employee = employeeServiceImpl.createEmployee(employeeDTO, deptid);
        return ResponseEntity.created(URI.create("/api/employees" + employee.getEmployeeID())).body(employee);
    }
    @Override
    public ResponseEntity<Void> deleteEmployee(String employeeId){
        employeeServiceImpl.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Employee> updateEmployee(String employeeId, EmployeeDTO employeeDTO){
        Employee result = employeeServiceImpl.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeAgeGreaterThan(Integer age){
        try{
            return ResponseEntity.ok().body(employeeServiceImpl.getEmployeeAgeGreaterThan(age));
        }catch (ResolutionException e){
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeWithFirstNameAndSalary(String firstName, Integer salary) {
        try{
            return ResponseEntity.ok().body(employeeServiceImpl.getEmployeeWithFirstNameAndSalary(firstName, salary));
        }catch (ResponseException e){
            throw e;
        }
    }
}
