package com.example.demo.rest;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO;
import com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO;
import com.example.demo.entity.Department;
import com.example.demo.exception.DemoException;
import com.example.demo.exception.ResponseException;
import com.example.demo.service.DepartmentService;
import com.example.demo.serviceimpl.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI{
    private final DepartmentServiceImpl departmentServiceImpl;
    @Override
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        return ResponseEntity.ok(departmentServiceImpl.getAllDepartment());
    }
    @Override
    public ResponseEntity<DepartmentDTO> findDepartmentById(Long deptid){
        return ResponseEntity.ok(departmentServiceImpl.findDepartmentById(deptid));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByName(String departmentName) {
        return ResponseEntity.ok(departmentServiceImpl.findByName(departmentName));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByNameIsNull(){
        return ResponseEntity.ok(departmentServiceImpl.findByNameIsNull());
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByNameNot(String departmentName){
        return ResponseEntity.ok(departmentServiceImpl.findByNameNot(departmentName));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByNameAndStartDate( String departmentName,LocalDate startDate){
        return ResponseEntity.ok(departmentServiceImpl.findByNameAndStartDate(departmentName, startDate));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByStartDate(LocalDate startDate){
        return ResponseEntity.ok(departmentServiceImpl.findByStartDate(startDate));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByStartDateBetween(LocalDate date1, LocalDate date2){
        return ResponseEntity.ok(departmentServiceImpl.findByStartDateBetween(date1, date2));
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> findByOrderByStartDateAsc(){
        return ResponseEntity.ok(departmentServiceImpl.findByOrderByStartDateAsc());
    }
    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO){
        Department department = departmentServiceImpl.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments" + department.getId())).body(department);
    }
    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptid){
        departmentServiceImpl.deleteDepartment(deptid);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Department> updateDepartment(Long deptid, DepartmentDTO departmentDTO){
        Department result = departmentServiceImpl.updateDepartment(deptid, departmentDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<DepartmentWithNumberOfEmployeesDTO>> getNumberOfEmployeesInDepartments(){
        return ResponseEntity.ok(departmentServiceImpl.getNumberOfEmployeesInDepartments());
    }
    @Override
    public ResponseEntity<List<DepartmentDTO>> getDepartmentByDepartmentNameOrStartDate(String name, LocalDate startDate){
        try{
            return ResponseEntity.ok().body(departmentServiceImpl.getDepartmentByDepartmentNameOrStartDate(name, startDate));
        }catch (ResponseException e){
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<DepartmentOfEmployeeWithMaxSalaryDTO>> getEmployeeWithMaxSalary() {
        try{
            return ResponseEntity.ok().body(departmentServiceImpl.getEmployeeWithMaxSalary());
        }catch (ResponseException e){
            throw e;
        }
    }
}
