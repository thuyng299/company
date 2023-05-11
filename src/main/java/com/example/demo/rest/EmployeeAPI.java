package com.example.demo.rest;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/employees")
public interface EmployeeAPI {
    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployee();

    @GetMapping(value = "/{employeeID}")
    ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable("employeeID") String employeeID);

    @GetMapping("/lastnameorfirstnames")
    ResponseEntity<List<Employee>> findByLastNameOrFirstName(@RequestParam("lastName") String lastName,
                                                            @RequestParam("firstName") String firstName);
    @GetMapping("/likefirstnames")
    ResponseEntity<List<Employee>> findByFirstNameLike(@RequestParam("firstName") String firstName);
    @GetMapping("/notlastnames")
    ResponseEntity<List<Employee>> findByLastNameNot(@RequestParam("lastName") String lastName);
    @GetMapping("/orderbysalaries")
    ResponseEntity<List<Employee>> findByOrderBySalary();
    @GetMapping("/dobafterdate")
    ResponseEntity<List<Employee>> findByDateOfBirthAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date);
    @PostMapping(value = "/{deptid}")
    ResponseEntity<Employee> createEmployee(@PathVariable("deptid") Long deptid,
                                            @RequestBody EmployeeDTO employeeDTO);
    @DeleteMapping("/{employeeId}")
    ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") String employeeId);

    @PutMapping("/{employeeId}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") String employeeId,
                                            @RequestBody EmployeeDTO employeeDTO);
    @GetMapping("/agegreaterthan")
    ResponseEntity<List<EmployeeDTO>> getEmployeeAgeGreaterThan(@RequestParam("age") @NotBlank Integer age);
    @GetMapping("/employeeswithfirstnameandsalary")
    ResponseEntity<List<EmployeeDTO>> getEmployeeWithFirstNameAndSalary(@RequestParam("firstName") @NotBlank String firstName,
                                                                        @RequestParam("salary") @NotBlank Integer salary);
}
