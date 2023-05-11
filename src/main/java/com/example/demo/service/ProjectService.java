package com.example.demo.service;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getProjectByNameOrDeptId(Long id);
    List<ProjectDTO> getProjectByAreaContains();
}
