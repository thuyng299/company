package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_of_hour", nullable = false)
    private Integer numberOfHour;
    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "projectid")
    private Project project;
}
