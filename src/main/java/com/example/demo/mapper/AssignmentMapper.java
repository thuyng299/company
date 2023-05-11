package com.example.demo.mapper;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.dto.RelativeDTO;
import com.example.demo.entity.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignmentMapper {
    AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);
    @Mapping(source = "employee.employeeID", target = "employeeID")
    @Mapping(source = "project.projectName", target = "projectName")
    AssignmentDTO toDto(Assignment assignment);
    List<AssignmentDTO> toDtos(List<Assignment> assignments);
}
