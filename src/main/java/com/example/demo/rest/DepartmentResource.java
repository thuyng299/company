package com.example.demo.rest;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI{
    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @Override
    public ResponseEntity<Optional<Department>> findDepartmentById(Long deptid){
        return ResponseEntity.ok(departmentService.findDepartmentById(deptid));
    }
    @Override
    public ResponseEntity<List<Department>> findByName(String departmentName){
        return ResponseEntity.ok(departmentService.findByName(departmentName));
    }
    @Override
    public ResponseEntity<List<Department>> findByNameIsNull(){
        return ResponseEntity.ok(departmentService.findByNameIsNull());
    }
    @Override
    public ResponseEntity<List<Department>> findByNameNot(String departmentName){
        return ResponseEntity.ok(departmentService.findByNameNot(departmentName));
    }
    @Override
    public ResponseEntity<List<Department>> findByNameAndStartDate( String departmentName,LocalDate startDate){
        return ResponseEntity.ok(departmentService.findByNameAndStartDate(departmentName, startDate));
    }
    @Override
    public ResponseEntity<List<Department>> findByStartDate(LocalDate startDate){
        return ResponseEntity.ok(departmentService.findByStartDate(startDate));
    }
    @Override
    public ResponseEntity<List<Department>> findByStartDateBetween(LocalDate date1, LocalDate date2){
        return ResponseEntity.ok(departmentService.findByStartDateBetween(date1, date2));
    }
    @Override
    public ResponseEntity<List<Department>> findByOrderByStartDateAsc(){
        return ResponseEntity.ok(departmentService.findByOrderByStartDateAsc());
    }
    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO){
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments" + department.getId())).body(department);
    }
    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptid){
        departmentService.deleteDepartment(deptid);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Department> updateDepartment(Long deptid, DepartmentDTO departmentDTO){
        Department result = departmentService.updateDepartment(deptid, departmentDTO);
        return ResponseEntity.ok().body(result);
    }
}
