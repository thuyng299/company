package com.example.demo.mapper;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDTO toDto(Department department);
    List<DepartmentDTO> toDtos(List<Department> departments);
}
