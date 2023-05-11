package com.example.demo.repository;

import com.example.demo.dto.RelativeOfEmpWithMinSalaryInDeptDTO;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Long> {
    List<Relative> findByFullNameOrGender(String fullName, Gender gender);
    List<Relative> findByFullName(String fullName);
    List<Relative> findByPhoneNumberNotNull();
    List<Relative> findByOrderByFullName();
    List<Relative> findByFullNameNot(String fullName);
    @Query(value = "select * from Relatives r, Employee e where r.employeeid = e.employee_id and e.employee_id like '%ACB456%' and r.gender like '1'", nativeQuery = true)
    List<Relative> getRelativeByGenderAndEmployeeId();
    @Query(nativeQuery = true)
    List<RelativeOfEmpWithMinSalaryInDeptDTO> getRelativeOfEmpWithMinSalaryInDept();
}
