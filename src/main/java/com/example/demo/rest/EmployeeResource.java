package com.example.demo.rest;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI{
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @Override
    public ResponseEntity<Optional<Employee>> findEmployeeById(String employeeID){
        return ResponseEntity.ok(employeeService.findEmployeeById(employeeID));
    }
    @Override
    public ResponseEntity<List<Employee>> findByLastNameOrFirstName(String lastName, String firstName){
        return ResponseEntity.ok(employeeService.findByLastNameOrFirstName(lastName,firstName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByFirstNameLike(String firstName){
        return ResponseEntity.ok(employeeService.findByFirstNameLike(firstName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByLastNameNot(String lastName){
        return ResponseEntity.ok(employeeService.findByLastNameNot(lastName));
    }
    @Override
    public ResponseEntity<List<Employee>> findByOrderBySalary(){
        return ResponseEntity.ok(employeeService.findByOrderBySalary());
    }
    @Override
    public ResponseEntity<List<Employee>> findByDateOfBirthAfter(LocalDate date){
        return ResponseEntity.ok(employeeService.findByDateOfBirthAfter(date));
    }
    @Override
    public ResponseEntity<Employee> createEmployee(Long deptid,EmployeeDTO employeeDTO){
        Employee employee = employeeService.createEmployee(employeeDTO, deptid);
        return ResponseEntity.created(URI.create("/api/employees" + employee.getEmployeeID())).body(employee);
    }
    @Override
    public ResponseEntity<Void> deleteEmployee(String employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Employee> updateEmployee(String employeeId, EmployeeDTO employeeDTO){
        Employee result = employeeService.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok().body(result);
    }
}
