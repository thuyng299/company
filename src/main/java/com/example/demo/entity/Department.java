package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "department")
@NamedQuery(name = "Department.getDepartmentByDepartmentNameOrStartDate",
            query = "select d from Department d where name like :name or startDate = :startDate")
@SqlResultSetMapping(
        name = "DepartmentEmployeeMaxSalary",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "employeeID", type = String.class),
                                @ColumnResult(name = "fullName", type = String.class),
                                @ColumnResult(name = "salary", type = Integer.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = Department.GET_EMPLOYEE_WITH_MAX_SALARY,
        query = "select d.id, d.department_name as name, e.employee_id as employeeID, concat(e.first_name, ' ', e.last_name) as fullName, e.salary" +
                " from department d, employee e where d.id = e.deptid and e.salary in (select max(e.salary) from employee e)",
        resultSetMapping = "DepartmentEmployeeMaxSalary")
public class Department {
    public static final String GET_EMPLOYEE_WITH_MAX_SALARY = "Department.getEmployeeWithMaxSalary";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departmentName", unique = true)
    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
}
