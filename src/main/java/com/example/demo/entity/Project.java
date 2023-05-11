package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
@NamedQuery(name = "Project.getProjectByNameOrDeptId",
            query = "select p from Project p, Department d where p.department.id = d.id and (p.projectName like '%Twitterlist%' or d.id = :id)")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;
    @Column(name = "area", nullable = false)
    private String area;
    @Column(name = "project_name", nullable = false)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "managed_department")
    private Department department;
}
