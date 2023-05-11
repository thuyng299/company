package com.example.demo.repository;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByAreaAndProjectName(String area, String projectName);
    List<Project> findByAreaEndingWith(String area);
    List<Project> findByProjectNameOrderByAreaDesc(String projectName);
    List<Project> findByProjectNameNot(String projectName);
    List<Project> findByProjectNameIgnoreCase(String projectName);
    List<Project> getProjectByNameOrDeptId(@Param("id") Long id);
    @Query(value = "select * from Project where area like '%S%'", nativeQuery = true)
    List<Project> getProjectByAreaContains();
}
