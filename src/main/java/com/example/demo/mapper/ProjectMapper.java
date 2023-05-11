package com.example.demo.mapper;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    @Mapping(source = "department.name", target = "departmentName")
    ProjectDTO toDto(Project project);
    List<ProjectDTO> toDtos (List<Project> projects);
}
