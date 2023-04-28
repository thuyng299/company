package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByName(String departmentName);
    List<Department> findByStartDate(LocalDate startDate);

    List<Department> findByStartDateBetween(LocalDate date1, LocalDate date2);
    List<Department> findByNameAndStartDate(String departmentName, LocalDate startDate);
    List<Department> findByNameIsNull();
    List<Department> findByOrderByStartDateAsc();
    List<Department> findByNameNot(String departmentName);
}
