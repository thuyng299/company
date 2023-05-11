package com.example.demo.serviceimpl;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.entity.Assignment;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.exception.DemoException;
import com.example.demo.mapper.AssignmentMapper;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignmentServiceImpl implements AssignmentService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final AssignmentRepository assignmentRepository;
    public List<Assignment> getAllAssignment(){
        return assignmentRepository.findAll();
    }
    public Optional<Assignment> findAssignmentById(Long assignId){

        return assignmentRepository.findById(assignId);
    }
    public List<Assignment> findByNumberOfHourLessThan(Integer hour){
        return assignmentRepository.findByNumberOfHourLessThan(hour);
    }
    public List<Assignment> findByNumberOfHourIsNull(){
        return assignmentRepository.findByNumberOfHourIsNull();
    }
    public List<Assignment> findByOrderByNumberOfHourDesc(){
        return assignmentRepository.findByOrderByNumberOfHourDesc();
    }
    public List<Assignment> findByNumberOfHourIn(Collection<Integer> hour){
        return assignmentRepository.findByNumberOfHourIn(hour);
    }
    public List<Assignment> findByIdOrNumberOfHour(Long assignId, Integer hour){
        return assignmentRepository.findByIdOrNumberOfHour(assignId, hour);
    }
    public Assignment createAssignment(AssignmentDTO assignmentDTO, String employeeid, Long projectid){
        Optional<Employee> employee = employeeRepository.findById(employeeid);
        Optional<Project> project = projectRepository.findById(projectid);

        Assignment assignment = new Assignment();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        if (employee.isPresent())
            assignment.setEmployee(employee.get());
        if (project.isPresent())
            assignment.setProject(project.get());
        return assignmentRepository.save(assignment);
    }
    public void deleteAssignment(Long assignId){
        assignmentRepository.deleteById(assignId);
    }
    public Assignment updateAssignment(Long assignId, AssignmentDTO assignmentDTO){
        Optional<Assignment> assignment = assignmentRepository.findById(assignId);
        Assignment updateAssignment = assignment.get();
        updateAssignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(updateAssignment);
    }
    @Override
    public List<AssignmentDTO> getAssignmentOfDept(Long id){
        log.info("find assignment of department {}", id);
        List<Assignment> assignments = assignmentRepository.getAssignmentOfDept(id);
        if (id == null || id < 0){
            throw DemoException.badRequest("InvalidId", "Department ID must be positive");
        }
        return AssignmentMapper.INSTANCE.toDtos(assignments);
    }
    @Override
    public List<AssignmentDTO> getAssignmentByHourAndProjectId(){
        log.info("find assignment by number of hour and project id");
        List<Assignment> assignments = assignmentRepository.getAssignmentByHourAndProjectId();
        if (assignments.isEmpty()){
            throw DemoException.AssignmentNotFound();
        }
        return AssignmentMapper.INSTANCE.toDtos(assignments);
    }

}
