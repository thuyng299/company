package com.example.demo.repository;

import com.example.demo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
