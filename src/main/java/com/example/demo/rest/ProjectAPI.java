package com.example.demo.rest;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/projects")
public interface ProjectAPI {
    @GetMapping
    ResponseEntity<List<Project>> getAllProject();
    @GetMapping(value = "/{projectId}")
    ResponseEntity<Optional<Project>> findProjectById(@PathVariable("projectId") Long projectId);
    @GetMapping("/areaandprojectnames")
    ResponseEntity<List<Project>> findByAreaAndProjectName(@RequestParam("area") String area,
                                                           @RequestParam("projectName") String projectName);
    @GetMapping("/areaendingwith")
    ResponseEntity<List<Project>> findByAreaEndingWith(@RequestParam("area") String area);
    @GetMapping("/projectnameorderbyareadesc")
    ResponseEntity<List<Project>> findByProjectNameOrderByAreaDesc(@RequestParam("projectName") String projectName);
    @GetMapping("/notprojectnames")
    ResponseEntity<List<Project>> findByProjectNameNot(@RequestParam("projectName") String projectName);
    @GetMapping("/ignorecaseprojectnames")
    ResponseEntity<List<Project>> findByProjectNameIgnoreCase(@RequestParam("projectName") String projectName);
    @PostMapping(value = "/{deptid}")
    ResponseEntity<Project> createProject(@PathVariable("deptid") Long deptid,
                                          @RequestBody ProjectDTO projectDTO);
    @DeleteMapping(value = "/{projectId}")
    ResponseEntity<Void> deleteProject(@PathVariable("projectId") Long projectId);

    @PutMapping(value = "/{projectId}")
    ResponseEntity<Project> updateProject(@PathVariable("projectId") Long projectId,
                                          @RequestBody ProjectDTO projectDTO);
}
