package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssignmentDTO {
    private Long id;
    private Integer numberOfHour;
    private String employeeID;
    private String projectName;
}
