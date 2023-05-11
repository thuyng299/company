package com.example.demo.mapper;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.entity.Relative;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RelativeMapper {
    RelativeMapper INSTANCE = Mappers.getMapper(RelativeMapper.class);
    @Mapping(source = "employee.firstName", target = "firstName")
    @Mapping(source = "employee.lastName", target = "lastName")
    RelativeDTO toDto(Relative relative);
    List<RelativeDTO> toDtos(List<Relative> relatives);
}
