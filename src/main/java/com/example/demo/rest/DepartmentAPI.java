package com.example.demo.rest;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping(value = "/{deptid}")
    ResponseEntity<Optional<Department>> findDepartmentById(@PathVariable("deptid") Long deptid);

    @GetMapping(value = "/reports")
    ResponseEntity<List<Department>> findByName(@RequestParam("departmentName") String departmentName);

    @GetMapping(value = "/startdates")
    ResponseEntity<List<Department>> findByStartDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
    @GetMapping(value = "/startdatesbetween")
    ResponseEntity<List<Department>> findByStartDateBetween(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                                            @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2);
    @GetMapping("/nulldatas")
    ResponseEntity<List<Department>> findByNameIsNull();
    @GetMapping("/namenot")
    ResponseEntity<List<Department>> findByNameNot(@RequestParam("departmentName") String departmentName);
    @GetMapping("/nameandstartdates")
    ResponseEntity<List<Department>> findByNameAndStartDate(@RequestParam("departmentName") String departmentName,
                                                           @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
    @GetMapping("/startdateasc")
    ResponseEntity<List<Department>> findByOrderByStartDateAsc();
    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping(value = "/{deptid}")
    ResponseEntity<Void> deleteDepartment(@PathVariable("deptid") Long deptid);

    @PutMapping(value = "/{deptid}")
    ResponseEntity<Department> updateDepartment(@PathVariable("deptid") Long deptid,
                                                @RequestBody DepartmentDTO departmentDTO);
}
