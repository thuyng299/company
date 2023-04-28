package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public Optional<Department> findDepartmentById(Long deptid){
        return departmentRepository.findById(deptid);
    }
    public List<Department> findByName(String departmentName){
        return departmentRepository.findByName(departmentName);
    }
    public List<Department> findByNameIsNull(){
        return departmentRepository.findByNameIsNull();
    }
    public List<Department> findByNameNot(String departmentName){
        return departmentRepository.findByNameNot(departmentName);
    }
    public List<Department>  findByNameAndStartDate(String departmentName, LocalDate startDate){
        return departmentRepository.findByNameAndStartDate(departmentName, startDate);
    }
    public List<Department> findByStartDate(LocalDate startDate){
        return departmentRepository.findByStartDate(startDate);
    }
    public List<Department> findByStartDateBetween(LocalDate date1, LocalDate date2){
            return departmentRepository.findByStartDateBetween(date1, date2);
    }
    public List<Department> findByOrderByStartDateAsc(){
        return departmentRepository.findByOrderByStartDateAsc();
    }
    public Department createDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long deptid){
        departmentRepository.deleteById(deptid);
    }
    public Department updateDepartment(Long deptid, DepartmentDTO departmentDTO){
        Optional<Department> department = departmentRepository.findById(deptid);
        Department updateDepartment = department.get();
        updateDepartment.setName(departmentDTO.getName());
        updateDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updateDepartment);
    }
}
