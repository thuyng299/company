package com.example.demo.mapper;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.DepartmentLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentLocationMapper {
    DepartmentLocationMapper INSTANCE = Mappers.getMapper(DepartmentLocationMapper.class);
    @Mapping(source = "department.name", target = "departmentName")
    DepartmentLocationDTO toDto(DepartmentLocation departmentLocation);
    List<DepartmentLocationDTO> toDtos(List<DepartmentLocation> departmentLocations);
}
