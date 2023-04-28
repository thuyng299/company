package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByLastNameOrFirstName(String lastName, String firstName);
    List<Employee> findByFirstNameLike(String firstName);
    List<Employee> findByLastNameNot(String lastName);
    List<Employee> findByOrderBySalary();
    List<Employee> findByDateOfBirthAfter(LocalDate date);

}
