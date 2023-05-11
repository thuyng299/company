package com.example.demo.rest;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO;
import com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO;
import com.example.demo.entity.Department;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping
    ResponseEntity<List<DepartmentDTO>> getAllDepartment();

    @GetMapping(value = "/{deptid}")
    ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable("deptid") Long deptid);

    @GetMapping(value = "/reports")
    ResponseEntity<List<DepartmentDTO>> findByName(@RequestParam("departmentName") String departmentName);

    @GetMapping(value = "/startdates")
    ResponseEntity<List<DepartmentDTO>> findByStartDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
    @GetMapping(value = "/startdatesbetween")
    ResponseEntity<List<DepartmentDTO>> findByStartDateBetween(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                                            @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2);
    @GetMapping("/nulldatas")
    ResponseEntity<List<DepartmentDTO>> findByNameIsNull();
    @GetMapping("/namenot")
    ResponseEntity<List<DepartmentDTO>> findByNameNot(@RequestParam("departmentName") String departmentName);
    @GetMapping("/nameandstartdates")
    ResponseEntity<List<DepartmentDTO>> findByNameAndStartDate(@RequestParam("departmentName") String departmentName,
                                                           @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
    @GetMapping("/startdateasc")
    ResponseEntity<List<DepartmentDTO>> findByOrderByStartDateAsc();
    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping(value = "/{deptid}")
    ResponseEntity<Void> deleteDepartment(@PathVariable("deptid") Long deptid);

    @PutMapping(value = "/{deptid}")
    ResponseEntity<Department> updateDepartment(@PathVariable("deptid") Long deptid,
                                                @RequestBody DepartmentDTO departmentDTO);
    @GetMapping("/numberofemployees")
    ResponseEntity<List<DepartmentWithNumberOfEmployeesDTO>> getNumberOfEmployeesInDepartments();
    @GetMapping("/departmentnameorstartdate")
    ResponseEntity<List<DepartmentDTO>> getDepartmentByDepartmentNameOrStartDate(@RequestParam("name") @NotBlank String name,
                                                                                 @RequestParam("startDate") @NotBlank @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
    @GetMapping("/getmaxsalary")
    ResponseEntity<List<DepartmentOfEmployeeWithMaxSalaryDTO>> getEmployeeWithMaxSalary();

}
