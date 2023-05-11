package com.example.demo.serviceimpl;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> findEmployeeById(String employeeId){
        return employeeRepository.findById(employeeId);
    }
    public List<Employee> findByLastNameOrFirstName(String lastName, String firstName){
        return employeeRepository.findByLastNameOrFirstName(lastName, firstName);
    }
    public List<Employee> findByFirstNameLike(String firstName){
        return employeeRepository.findByFirstNameLike(firstName);
    }
    public List<Employee> findByLastNameNot(String lastName){
        return employeeRepository.findByLastNameNot(lastName);
    }
    public List<Employee> findByOrderBySalary(){
        return employeeRepository.findByOrderBySalary();
    }
    public List<Employee> findByDateOfBirthAfter(LocalDate date){
        return employeeRepository.findByDateOfBirthAfter(date);
    }

    public Employee createEmployee(EmployeeDTO employeeDTO, Long deptid){
        Optional<Department> department = departmentRepository.findById(deptid);

        Employee employee = new Employee();
        employee.setEmployeeID(employeeDTO.getEmployeeID());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setGender(employeeDTO.getGender());
        employee.setLastName(employeeDTO.getLastName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setSalary(employeeDTO.getSalary());
        if (department.isPresent())
            employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(String employeeId){
        employeeRepository.deleteById(employeeId);
    }
    public Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee updateEmployee = employee.get();
        updateEmployee.setEmployeeID(employeeDTO.getEmployeeID());
        updateEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        updateEmployee.setFirstName(employeeDTO.getFirstName());
        updateEmployee.setGender(employeeDTO.getGender());
        updateEmployee.setLastName(employeeDTO.getLastName());
        updateEmployee.setMiddleName(employeeDTO.getMiddleName());
        updateEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(updateEmployee);
    }
    @Override
    public List<EmployeeDTO> getEmployeeAgeGreaterThan(Integer age){
        log.info("find employee with age greater than {}");
        List<Employee> employees = employeeRepository.getEmployeeAgeGreaterThan(age);
        if (employees.isEmpty()){
            throw DemoException.EmployeeNotFound();
        }
        if (age == null){
            throw DemoException.badRequest("EmptyAge", "Age cannot be null");
        }
        return EmployeeMapper.INSTANCE.toDtos(employees);
    }
    @Override
    public List<EmployeeDTO> getEmployeeWithFirstNameAndSalary(String firstName, Integer salary){
        log.info("find employee with first name and salary greater than {}", firstName, salary);
        List<Employee> employees = employeeRepository.getEmployeeWithFirstNameAndSalary(firstName, salary);
        if (employees.isEmpty()){
            throw DemoException.EmployeeNotFound();
        }
        if (firstName.isBlank()){
            throw DemoException.badRequest("EmptyFirstName", "First name cannot be blank");
        }
        if (salary < 0){
            throw DemoException.badRequest("InvalidSalary", "Salary cannot be negative");
        }
        return EmployeeMapper.INSTANCE.toDtos(employees);
    }
}
