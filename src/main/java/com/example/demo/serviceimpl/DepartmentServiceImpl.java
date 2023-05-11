package com.example.demo.serviceimpl;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DepartmentOfEmployeeWithMaxSalaryDTO;
import com.example.demo.dto.DepartmentWithNumberOfEmployeesDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentDTO> getAllDepartment(){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findAll());
    }
    @Override
    public DepartmentDTO findDepartmentById(Long deptid){
        Department department = departmentRepository.findById(deptid).orElseThrow(DemoException::DepartmentNotFound);
        return DepartmentMapper.INSTANCE.toDto(department);
    }
    @Override
    public List<DepartmentDTO> findByName(String departmentName) {
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByName(departmentName));
    }
    @Override
    public List<DepartmentDTO> findByNameIsNull(){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByNameIsNull());
    }
    @Override
    public List<DepartmentDTO> findByNameNot(String departmentName){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByNameNot(departmentName));
    }
    @Override
    public List<DepartmentDTO>  findByNameAndStartDate(String departmentName, LocalDate startDate){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByNameAndStartDate(departmentName, startDate));
    }
    @Override
    public List<DepartmentDTO> findByStartDate(LocalDate startDate){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByStartDate(startDate));
    }
    @Override
    public List<DepartmentDTO> findByStartDateBetween(LocalDate date1, LocalDate date2){
            return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByStartDateBetween(date1, date2));
    }
    @Override
    public List<DepartmentDTO> findByOrderByStartDateAsc(){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByOrderByStartDateAsc());
    }
    @Override
    public Department createDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    @Override
    public void deleteDepartment(Long deptid){
        departmentRepository.deleteById(deptid);
    }
    @Override
    public Department updateDepartment(Long deptid, DepartmentDTO departmentDTO){
        Optional<Department> department = departmentRepository.findById(deptid);
        Department updateDepartment = department.get();
        updateDepartment.setName(departmentDTO.getName());
        updateDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updateDepartment);
    }
    @Override
    public List<DepartmentWithNumberOfEmployeesDTO> getNumberOfEmployeesInDepartments(){
        return departmentRepository.getNumberOfEmployeesInDepartments();
    }
    @Override
    public List<DepartmentDTO> getDepartmentByDepartmentNameOrStartDate(String name, LocalDate startDate){
        log.info("find department by name and start date {}", name, startDate);
        List<Department> department = departmentRepository.getDepartmentByDepartmentNameOrStartDate(name, startDate);
        if(department.isEmpty()){
            throw DemoException.DepartmentNotFound();
        }
        if (startDate.isAfter(LocalDate.now())){
            throw DemoException.badRequest("WrongDate", "Date cannot be after today");
        }
        if (name == null || name.isBlank()){
            throw DemoException.badRequest("EmptyName", "Department name cannot be blank");
        }
        return DepartmentMapper.INSTANCE.toDtos(department);
    }
    @Override
    public List<DepartmentOfEmployeeWithMaxSalaryDTO> getEmployeeWithMaxSalary(){
        log.info(("find employee with max salary {}"));
        List<DepartmentOfEmployeeWithMaxSalaryDTO> departments = departmentRepository.getEmployeeWithMaxSalary();
        if (departments.isEmpty()){
            throw DemoException.DepartmentNotFound();
        }
        return departments;
    }

}
