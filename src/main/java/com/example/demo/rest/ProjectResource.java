package com.example.demo.rest;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI{
    private final ProjectService projectService;
    @Override
    public ResponseEntity<List<Project>> getAllProject(){
        return ResponseEntity.ok(projectService.getAllProject());
    }
    @Override
    public  ResponseEntity<Optional<Project>> findProjectById(Long projectId){
        return ResponseEntity.ok(projectService.findProjectById(projectId));
    }
    @Override
    public ResponseEntity<List<Project>> findByAreaAndProjectName(String area, String projectName){
        return ResponseEntity.ok(projectService.findByAreaAndProjectName(area, projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByAreaEndingWith(String area){
        return ResponseEntity.ok(projectService.findByAreaEndingWith(area));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameOrderByAreaDesc(String projectName){
        return ResponseEntity.ok(projectService.findByProjectNameOrderByAreaDesc(projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameNot(String projectName){
        return ResponseEntity.ok(projectService.findByProjectNameNot(projectName));
    }
    @Override
    public ResponseEntity<List<Project>> findByProjectNameIgnoreCase(String projectName){
        return ResponseEntity.ok(projectService.findByProjectNameIgnoreCase(projectName));
    }
    @Override
    public ResponseEntity<Project> createProject(Long deptid, ProjectDTO projectDTO){
        Project project = projectService.createProject(projectDTO, deptid);
        return ResponseEntity.created(URI.create("/api/projects" + project.getProjectID())).body(project);
    }
    @Override
    public ResponseEntity<Void> deleteProject(Long projectId){
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Project> updateProject(Long projectId, ProjectDTO projectDTO){
        Project result = projectService.updateProject(projectId, projectDTO);
        return ResponseEntity.ok().body(result);
    }
}
