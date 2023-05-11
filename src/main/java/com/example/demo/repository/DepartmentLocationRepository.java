package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation, Long> {
    List<DepartmentLocation> findByLocation(String location);
    List<DepartmentLocation> findByLocationIsNull();
    List<DepartmentLocation> findByOrderByLocationDesc();
    List<DepartmentLocation> findByLocationIgnoreCase(String location);
    List<DepartmentLocation> findByLocationNot(String location);
    @Query("select dl from DepartmentLocation dl where dl.department.id = :id")
    List<DepartmentLocation> getLocationOfDepartment(@Param("id") Long id);
    List<DepartmentLocation> getLocationByNameAndDeptName();
}
