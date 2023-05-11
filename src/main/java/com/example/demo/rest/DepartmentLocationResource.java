package com.example.demo.rest;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.exception.ResponseException;
import com.example.demo.serviceimpl.DepartmentLocationServiceImpl;
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
public class DepartmentLocationResource implements DepartmentLocationAPI{
    private final DepartmentLocationServiceImpl departmentLocationServiceImpl;

    @Override
    public ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation(){
        return ResponseEntity.ok(departmentLocationServiceImpl.getAllDepartmentLocation());
    }
    @Override
    public ResponseEntity<Optional<DepartmentLocation>> findDepartmentLocationById(Long locationId){
        return ResponseEntity.ok(departmentLocationServiceImpl.findDepartmentLocationById(locationId));
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocation(String location){
        return ResponseEntity.ok(departmentLocationServiceImpl.findByLocation(location));
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationIsNull(){
        return ResponseEntity.ok(departmentLocationServiceImpl.findByLocationIsNull());
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByOrderByLocationDesc(){
        return ResponseEntity.ok(departmentLocationServiceImpl.findByOrderByLocationDesc());
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationIgnoreCase(String location){
        return ResponseEntity.ok(departmentLocationServiceImpl.findByLocationIgnoreCase(location));
    }

    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationNot(String location) {
        return ResponseEntity.ok(departmentLocationServiceImpl.findByLocationNot(location));
    }

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(Long deptid, DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = departmentLocationServiceImpl.createDepartmentLocation(departmentLocationDTO, deptid);
        return ResponseEntity.created(URI.create("/api/departmentlocations/" + departmentLocation.getId())).body(departmentLocation);
    }
    @Override
    public ResponseEntity<Void> deleteDepartmentLocation(Long locationId){
        departmentLocationServiceImpl.deleteDepartmentLocation(locationId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<DepartmentLocation> updateDepartmentLocation(Long locationId, DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation result = departmentLocationServiceImpl.updateDepartmentLocation(locationId, departmentLocationDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<DepartmentLocationDTO>> getLocationOfDepartment(Long id){
        try {
            return ResponseEntity.ok().body(departmentLocationServiceImpl.getLocationOfDepartment(id));
        }catch (ResponseException e){
            throw e;
        }
    }
    @Override
    public ResponseEntity<List<DepartmentLocationDTO>> getLocationByNameAndDeptName(){
        try {
            return ResponseEntity.ok().body(departmentLocationServiceImpl.getLocationByNameAndDeptName());
        }catch (ResponseException e){
            throw e;
        }
    }
}
