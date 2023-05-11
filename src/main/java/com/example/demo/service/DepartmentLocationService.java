package com.example.demo.service;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.DepartmentLocation;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentLocationService {
    List<DepartmentLocationDTO> getLocationOfDepartment(Long id);
    List<DepartmentLocationDTO> getLocationByNameAndDeptName();
}
