package com.example.demo.service;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.dto.RelativeOfEmpWithMinSalaryInDeptDTO;
import com.example.demo.entity.Relative;

import java.util.List;

public interface RelativeService {
    List<RelativeDTO> getRelativeByGenderAndEmployeeId();
    List<RelativeOfEmpWithMinSalaryInDeptDTO> getRelativeOfEmpWithMinSalaryInDept();
}
