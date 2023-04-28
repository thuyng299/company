package com.example.demo.rest;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI{
    private final AssignmentService assignmentService;
    @Override
    public ResponseEntity<List<Assignment>> getAllAssignment(){
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }
    @Override
    public ResponseEntity <Optional<Assignment>> findAssignmentById(Long assignId){
        return ResponseEntity.ok(assignmentService.findAssignmentById(assignId));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourLessThan(Integer hour){
        return ResponseEntity.ok(assignmentService.findByNumberOfHourLessThan(hour));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourIsNull(){
        return ResponseEntity.ok(assignmentService.findByNumberOfHourIsNull());
    }
    @Override
    public ResponseEntity<List<Assignment>> findByOrderByNumberOfHourDesc(){
        return ResponseEntity.ok(assignmentService.findByOrderByNumberOfHourDesc());
    }
    @Override
    public ResponseEntity<List<Assignment>> findByNumberOfHourIn(Collection<Integer> hour){
        return ResponseEntity.ok(assignmentService.findByNumberOfHourIn(hour));
    }
    @Override
    public ResponseEntity<List<Assignment>> findByIdOrNumberOfHour(Long assignId, Integer hour){
        return ResponseEntity.ok(assignmentService.findByIdOrNumberOfHour(assignId, hour));
    }
    @Override
    public ResponseEntity<Assignment> createAssignment(String employeeID, Long projectID, AssignmentDTO assignmentDTO){
        Assignment assignment = assignmentService.createAssignment(assignmentDTO, employeeID, projectID);
        return ResponseEntity.created(URI.create("/api/assignments" + assignment.getId())).body(assignment);
    }
    @Override
    public ResponseEntity<Void> deleteAssignment(Long assignId){
        assignmentService.deleteAssignment(assignId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Assignment> updateAssignment(Long assignId, AssignmentDTO assignmentDTO){
        Assignment result = assignmentService.updateAssignment(assignId, assignmentDTO);
        return ResponseEntity.ok().body(result);
    }
}
