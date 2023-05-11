package com.example.demo.serviceimpl;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.dto.RelativeOfEmpWithMinSalaryInDeptDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import com.example.demo.exception.DemoException;
import com.example.demo.mapper.RelativeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RelativeRepository;
import com.example.demo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeServiceImpl implements RelativeService {
    private final EmployeeRepository employeeRepository;
    private final RelativeRepository relativeRepository;
    public List<Relative> getAllRelative(){
        return relativeRepository.findAll();
    }
    public Optional<Relative> findRelativeById(Long relativeId){
        return relativeRepository.findById(relativeId);
    }
    public List<Relative> findByFullNameOrGender(String fullName, Gender gender){
        return relativeRepository.findByFullNameOrGender(fullName,gender);
    }
    public List<Relative> findByFullName(String fullName){
        return relativeRepository.findByFullName(fullName);
    }
    public List<Relative> findByPhoneNumberNotNull(){
        return relativeRepository.findByPhoneNumberNotNull();
    }
    public List<Relative> findByOrderByFullName(){
        return relativeRepository.findByOrderByFullName();
    }
    public List<Relative> findByFullNameNot(String fullName){
        return relativeRepository.findByFullNameNot(fullName);
    }
    public Relative createRelative(RelativeDTO relativeDTO, String employeeid){
        Optional<Employee> employee = employeeRepository.findById(employeeid);

        Relative relative = new Relative();
        relative.setFullName(relativeDTO.getFullName());
        relative.setGender(relativeDTO.getGender());
        relative.setPhoneNumber(relativeDTO.getPhoneNumber());
        relative.setRelationship(relativeDTO.getRelationship());
        if (employee.isPresent())
            relative.setEmployee(employee.get());
        return relativeRepository.save(relative);
    }
    public void deleteRelative(Long relativeId){
        relativeRepository.deleteById(relativeId);
    }
    public Relative updateRelative(Long relativeId, RelativeDTO relativeDTO){
        Optional<Relative> relative = relativeRepository.findById(relativeId);
        Relative updateRelative = relative.get();
        updateRelative.setFullName(relativeDTO.getFullName());
        updateRelative.setGender(relativeDTO.getGender());
        updateRelative.setPhoneNumber(relativeDTO.getPhoneNumber());
        updateRelative.setRelationship(relativeDTO.getRelationship());
        return relativeRepository.save(updateRelative);
    }
    @Override
    public List<RelativeDTO> getRelativeByGenderAndEmployeeId(){
        log.info("find relative by gender and employee id {}");
        List<Relative> relatives = relativeRepository.getRelativeByGenderAndEmployeeId();
        if (relatives.isEmpty()){
            throw DemoException.RelativeNotFound();
        }
        return RelativeMapper.INSTANCE.toDtos(relatives);
    }
    @Override
    public List<RelativeOfEmpWithMinSalaryInDeptDTO> getRelativeOfEmpWithMinSalaryInDept(){
        log.info("find relative of employee with min salary in department {}");
        List<RelativeOfEmpWithMinSalaryInDeptDTO> relatives = relativeRepository.getRelativeOfEmpWithMinSalaryInDept();
        if (relatives.isEmpty()){
            throw DemoException.RelativeNotFound();
        }
        return relatives;

    }
}