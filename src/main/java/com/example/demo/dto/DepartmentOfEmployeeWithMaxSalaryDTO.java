package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentOfEmployeeWithMaxSalaryDTO {
    private Long id;
    private String name;
    private String employeeID;
    private String fullName;
    private Integer salary;
}
