package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation, Long> {
    List<DepartmentLocation> findByLocation(String location);
    List<DepartmentLocation> findByLocationIsNull();
    List<DepartmentLocation> findByOrderByLocationDesc();
    List<DepartmentLocation> findByLocationIgnoreCase(String location);
    List<DepartmentLocation> findByLocationNot(String location);
}
