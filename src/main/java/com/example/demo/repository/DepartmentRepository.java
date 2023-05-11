package com.example.demo.repository;

import com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO;
import com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO;
import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;
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
    @Query("select new com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO(d.name, count(d.id)) from Department d left join Employee e on d.id = e.department.id group by d.id")
    List<DepartmentWithNumberOfEmployeesDTO> getNumberOfEmployeesInDepartments();
    List<Department> getDepartmentByDepartmentNameOrStartDate(@Param("name") String name,
                                                              @Param("startDate") LocalDate startDate);
    @Query(nativeQuery = true)
    List<DepartmentOfEmployeeWithMaxSalaryDTO> getEmployeeWithMaxSalary();

}
