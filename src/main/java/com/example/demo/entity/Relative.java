package com.example.demo.entity;

import com.example.demo.mapper.GenderAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatives")
@SqlResultSetMapping(
        name = "RelativeOfEmployeeWithMinSalaryInDepartment",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demo.dto.RelativeOfEmpWithMinSalaryInDeptDTO.class,
                        columns = {
                                @ColumnResult(name = "fullName", type = String.class),
                                @ColumnResult(name = "phoneNumber", type = String.class),
                                @ColumnResult(name = "relationship", type = String.class),
                                @ColumnResult(name = "employeeName", type = String.class),
                                @ColumnResult(name = "salary", type = Integer.class),
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = Relative.GET_RELATIVE_OF_EMPLOYEE_WITH_MIN_SALARY_IN_DEPT,
        query = "select r.full_name as fullName, r.phone_number as phoneNumber, r.relationship, concat(e.first_name, ' ', e.last_name) as employeeName, e.salary, e.deptid as id, d.department_name as name from relatives r, employee e, department d where r.employeeid = e.employee_id and e.deptid = d.id and e.salary in (select min(e2.salary) from employee e2 group by e2.deptid having e2.deptid = 7)",
        resultSetMapping = "RelativeOfEmployeeWithMinSalaryInDepartment")
public class Relative {
    public static final String GET_RELATIVE_OF_EMPLOYEE_WITH_MIN_SALARY_IN_DEPT = "Relative.getRelativeOfEmpWithMinSalaryInDept";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Convert(converter = GenderAttributeConverter.class)
    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "relationship", nullable = false)
    private String relationship;
    @ManyToOne
    @JoinColumn(name = "employeeid", nullable = false)
    private Employee employee;
}
