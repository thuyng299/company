package com.example.demo.rest;

import com.example.demo.dto.AssignmentDTO;
import com.example.demo.entity.Assignment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/assignments")
public interface AssignmentAPI {
    @GetMapping
    ResponseEntity<List<Assignment>> getAllAssignment();
    @GetMapping(value = "/{assignId}")
    ResponseEntity <Optional<Assignment>> findAssignmentById(@PathVariable("assignId") Long assignId);
    @GetMapping("/lessthanhours")
    ResponseEntity<List<Assignment>> findByNumberOfHourLessThan(@RequestParam("hour") Integer hour);
    @GetMapping("/nullhours")
    ResponseEntity<List<Assignment>> findByNumberOfHourIsNull();
    @GetMapping("/orderbyhours")
    ResponseEntity<List<Assignment>> findByOrderByNumberOfHourDesc();
    @GetMapping("/inhours")
    ResponseEntity<List<Assignment>> findByNumberOfHourIn(@RequestParam("hour") Collection<Integer> hour);
    @GetMapping("/idorhours")
    ResponseEntity<List<Assignment>> findByIdOrNumberOfHour(@RequestParam("assignId") Long assignId,
                                                            @RequestParam("hour") Integer hour);
    @PostMapping(value = "/{employeeID}/{projectID}")
    ResponseEntity<Assignment> createAssignment(@PathVariable("employeeID") String employeeID,
                                                @PathVariable("projectID") Long projectID,
                                                @RequestBody AssignmentDTO assignmentDTO);
    @DeleteMapping(value = "/{assignId}")
    ResponseEntity<Void> deleteAssignment(@PathVariable("assignId") Long assignId);
    @PutMapping(value = "/{assignId}")
    ResponseEntity<Assignment> updateAssignment(@PathVariable("assignId") Long assignId,
                                                @RequestBody AssignmentDTO assignmentDTO);
}
