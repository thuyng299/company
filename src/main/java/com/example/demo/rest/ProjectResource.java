package com.example.demo.rest;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.exception.ResponseException;
import com.example.demo.serviceimpl.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI{
    private final ProjectServiceImpl projectServiceImpl;
    @Override
    public ResponseEntity<List<Project>> getAllProject(){
        return ResponseEntity.ok(projectServiceImpl.getAllProject());
    }
    @Override
    public  ResponseEntity<Optional<Project>> findProjectById(Long projectId){
        return ResponseEntity.ok(projectServiceImpl.findProjectById(projectId));
    }
    @Override
    public ResponseEntity<List<Project>> findByAreaAndProjectName(String area, String projectName){
        return ResponseEntity.ok(projectServiceImpl.findByAreaAndProjectName(area, projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByAreaEndingWith(String area){
        return ResponseEntity.ok(projectServiceImpl.findByAreaEndingWith(area));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameOrderByAreaDesc(String projectName){
        return ResponseEntity.ok(projectServiceImpl.findByProjectNameOrderByAreaDesc(projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameNot(String projectName){
        return ResponseEntity.ok(projectServiceImpl.findByProjectNameNot(projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameIgnoreCase(String projectName){
        return ResponseEntity.ok(projectServiceImpl.findByProjectNameIgnoreCase(projectName));
    }
    @Override
    public ResponseEntity<Project> createProject(Long deptid, ProjectDTO projectDTO){
        Project project = projectServiceImpl.createProject(projectDTO, deptid);
        return ResponseEntity.created(URI.create("/api/projects" + project.getProjectID())).body(project);
    }
    @Override
    public ResponseEntity<Void> deleteProject(Long projectId){
        projectServiceImpl.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Project> updateProject(Long projectId, ProjectDTO projectDTO){
        Project result = projectServiceImpl.updateProject(projectId, projectDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<ProjectDTO>> getProjectByNameOrDeptId(Long id){
        try {
            return ResponseEntity.ok().body(projectServiceImpl.getProjectByNameOrDeptId(id));
        }catch (ResponseException e){
            throw e;
        }
    }
    @Override
    public ResponseEntity<List<ProjectDTO>> getProjectByAreaContains(){
        try {
            return ResponseEntity.ok().body(projectServiceImpl.getProjectByAreaContains());
        }catch (ResponseException e){
            throw e;
        }
    }
}
