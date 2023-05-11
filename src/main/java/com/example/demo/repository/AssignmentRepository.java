package com.example.demo.repository;

import com.example.demo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByNumberOfHourLessThan(Integer hour);
    List<Assignment> findByNumberOfHourIsNull();
    List<Assignment> findByOrderByNumberOfHourDesc();
    List<Assignment> findByNumberOfHourIn(Collection<Integer> hour);
    List<Assignment> findByIdOrNumberOfHour(Long assignId, Integer hour);
    List<Assignment> getAssignmentOfDept(@Param("id") Long id);
    @Query(value = "select * from \"assignment\" where number_of_hour > 90 and projectid = 10 ", nativeQuery = true)
    List<Assignment> getAssignmentByHourAndProjectId();
}
