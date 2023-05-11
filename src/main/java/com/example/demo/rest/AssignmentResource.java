package com.example.demo.rest;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.entity.Assignment;
import com.example.demo.exception.ResponseException;
import com.example.demo.serviceimpl.AssignmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI{
    private final AssignmentServiceImpl assignmentServiceImpl;
    @Override
    public ResponseEntity<List<Assignment>> getAllAssignment(){
        return ResponseEntity.ok(assignmentServiceImpl.getAllAssignment());
    }
    @Override
    public ResponseEntity <Optional<Assignment>> findAssignmentById(Long assignId){
        return ResponseEntity.ok(assignmentServiceImpl.findAssignmentById(assignId));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourLessThan(Integer hour){
        return ResponseEntity.ok(assignmentServiceImpl.findByNumberOfHourLessThan(hour));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourIsNull(){
        return ResponseEntity.ok(assignmentServiceImpl.findByNumberOfHourIsNull());
    }
    @Override
    public ResponseEntity<List<Assignment>> findByOrderByNumberOfHourDesc(){
        return ResponseEntity.ok(assignmentServiceImpl.findByOrderByNumberOfHourDesc());
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourIn(Collection<Integer> hour){
        return ResponseEntity.ok(assignmentServiceImpl.findByNumberOfHourIn(hour));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByIdOrNumberOfHour(Long assignId, Integer hour){
        return ResponseEntity.ok(assignmentServiceImpl.findByIdOrNumberOfHour(assignId, hour));
    }
    @Override
    public ResponseEntity<Assignment> createAssignment(String employeeID, Long projectID, AssignmentDTO assignmentDTO){
        Assignment assignment = assignmentServiceImpl.createAssignment(assignmentDTO, employeeID, projectID);
        return ResponseEntity.created(URI.create("/api/assignments" + assignment.getId())).body(assignment);
    }
    @Override
    public ResponseEntity<Void> deleteAssignment(Long assignId){
        assignmentServiceImpl.deleteAssignment(assignId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Assignment> updateAssignment(Long assignId, AssignmentDTO assignmentDTO){
        Assignment result = assignmentServiceImpl.updateAssignment(assignId, assignmentDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<AssignmentDTO>> getAssignmentOfDept(Long id){
        try {
            return ResponseEntity.ok().body(assignmentServiceImpl.getAssignmentOfDept(id));
        }catch (ResponseException e){
            throw e;
        }
    }
    @Override
    public ResponseEntity<List<AssignmentDTO>> getAssignmentByHourAndProjectId(){
        try{
            return ResponseEntity.ok().body(assignmentServiceImpl.getAssignmentByHourAndProjectId());
        }catch (ResponseException e){
            throw e;
        }
    }
}
