package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeID;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;
}
