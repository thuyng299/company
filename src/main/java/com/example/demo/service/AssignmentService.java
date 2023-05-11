package com.example.demo.service;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.entity.Assignment;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentService {
    List<AssignmentDTO> getAssignmentOfDept(Long id);
    List<AssignmentDTO> getAssignmentByHourAndProjectId();
}
