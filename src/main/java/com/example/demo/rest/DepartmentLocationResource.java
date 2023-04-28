package com.example.demo.rest;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentLocationResource implements DepartmentLocationAPI{
    private final DepartmentLocationService departmentLocationService;

    @Override
    public ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation(){
        return ResponseEntity.ok(departmentLocationService.getAllDepartmentLocation());
    }
    @Override
    public ResponseEntity<Optional<DepartmentLocation>> findDepartmentLocationById(Long locationId){
        return ResponseEntity.ok(departmentLocationService.findDepartmentLocationById(locationId));
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocation(String location){
        return ResponseEntity.ok(departmentLocationService.findByLocation(location));
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationIsNull(){
        return ResponseEntity.ok(departmentLocationService.findByLocationIsNull());
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByOrderByLocationDesc(){
        return ResponseEntity.ok(departmentLocationService.findByOrderByLocationDesc());
    }
    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationIgnoreCase(String location){
        return ResponseEntity.ok(departmentLocationService.findByLocationIgnoreCase(location));
    }

    @Override
    public ResponseEntity<List<DepartmentLocation>> findByLocationNot(String location) {
        return ResponseEntity.ok(departmentLocationService.findByLocationNot(location));
    }

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(Long deptid, DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = departmentLocationService.createDepartmentLocation(departmentLocationDTO, deptid);
        return ResponseEntity.created(URI.create("/api/departmentlocations/" + departmentLocation.getId())).body(departmentLocation);
    }
    @Override
    public ResponseEntity<Void> deleteDepartmentLocation(Long locationId){
        departmentLocationService.deleteDepartmentLocation(locationId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<DepartmentLocation> updateDepartmentLocation(Long locationId, DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation result = departmentLocationService.updateDepartmentLocation(locationId, departmentLocationDTO);
        return ResponseEntity.ok().body(result);
    }
}
