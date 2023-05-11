package com.example.demo.serviceimpl;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.exception.DemoException;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    public Optional<Project> findProjectById(Long projectId){

        return projectRepository.findById(projectId);
    }
    public List<Project> findByAreaAndProjectName(String area, String projectName){
        return projectRepository.findByAreaAndProjectName(area, projectName);
    }
    public List<Project> findByAreaEndingWith(String area){
        return projectRepository.findByAreaEndingWith(area);
    }
    public List<Project> findByProjectNameOrderByAreaDesc(String projectName){
        return projectRepository.findByProjectNameOrderByAreaDesc(projectName);
    }
    public List<Project> findByProjectNameNot(String projectName){
        return projectRepository.findByProjectNameNot(projectName);
    }
    public List<Project> findByProjectNameIgnoreCase(String projectName){
        return projectRepository.findByProjectNameIgnoreCase(projectName);
    }
    public Project createProject(ProjectDTO projectDTO, Long managed_department){
        Optional<Department> department = departmentRepository.findById(managed_department);

        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        if (department.isPresent())
            project.setDepartment(department.get());
        return projectRepository.save(project);
    }
    public void deleteProject(Long projectID){
        projectRepository.deleteById(projectID);
    }
    public Project updateProject(Long projectID, ProjectDTO projectDTO){
        Optional<Project> project = projectRepository.findById(projectID);
        Project updateProject = project.get();
        updateProject.setArea(projectDTO.getArea());
        updateProject.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(updateProject);
    }
    @Override
    public List<ProjectDTO> getProjectByNameOrDeptId(Long id){
        log.info("find project by name and department id {}", id);
        List<Project> projects = projectRepository.getProjectByNameOrDeptId(id);
        if (id < 0){
            throw DemoException.badRequest("InvalidDepartmentId", "ID cannot be negative");
        }
        if (projects.isEmpty()){
            throw DemoException.ProjectNotFound();
        }
        return ProjectMapper.INSTANCE.toDtos(projects);
    }
    @Override
    public List<ProjectDTO> getProjectByAreaContains(){
        log.info("find project by area name contains {}");
        List<Project> projects = projectRepository.getProjectByAreaContains();
        if (projects.isEmpty()){
            throw DemoException.ProjectNotFound();
        }
        return ProjectMapper.INSTANCE.toDtos(projects);
    }
}
