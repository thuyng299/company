package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "select * from employee e where extract(year from age(current_date , date_of_birth)) > :age", nativeQuery = true)
    List<Employee> getEmployeeAgeGreaterThan(@Param("age") Integer age);
    @Query("select e from Employee e where firstName like :firstName and salary > :salary")
    List<Employee> getEmployeeWithFirstNameAndSalary (@Param("firstName") String firstName,
                                            @Param("salary") Integer salary);
}
