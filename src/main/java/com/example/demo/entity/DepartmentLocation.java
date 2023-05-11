package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department_location")
@NamedQuery(name = "DepartmentLocation.getLocationByNameAndDeptName",
            query = "select dl from DepartmentLocation dl, Department d where dl.department.id = d.id and d.name like '%abc%'and dl.location like '%i%'")
public class DepartmentLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "location", nullable = false, unique = true)
    private String location;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;



}
