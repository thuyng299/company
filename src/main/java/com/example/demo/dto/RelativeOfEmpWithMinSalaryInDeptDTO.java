package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelativeOfEmpWithMinSalaryInDeptDTO {
    private String fullName;
    private String phoneNumber;
    private String relationship;
    private String employeeName;
    private Integer salary;
    private Long id;
    private String name;
}
