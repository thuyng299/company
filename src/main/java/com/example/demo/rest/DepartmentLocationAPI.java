package com.example.demo.rest;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.DepartmentLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/departmentlocations")
public interface DepartmentLocationAPI {
    @GetMapping
    ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation();

    @GetMapping(value = "/{locationId}")
    ResponseEntity<Optional<DepartmentLocation>> findDepartmentLocationById(@PathVariable("locationId") Long locationId);
    @GetMapping("/locationnames")
    ResponseEntity<List<DepartmentLocation>> findByLocation(@RequestParam("location") String location);
    @GetMapping("/namenulldatas")
    ResponseEntity<List<DepartmentLocation>> findByLocationIsNull();
    @GetMapping("/nameorderdesc")
    ResponseEntity<List<DepartmentLocation>> findByOrderByLocationDesc();
    @GetMapping("/nameignorecase")
    ResponseEntity<List<DepartmentLocation>> findByLocationIgnoreCase(@RequestParam("location") String location);
    @GetMapping("/notnames")
    ResponseEntity<List<DepartmentLocation>> findByLocationNot(@RequestParam("location") String location);
    @PostMapping(value = "/{deptid}")
    ResponseEntity<DepartmentLocation> createDepartmentLocation(@PathVariable("deptid") Long deptid,
            @RequestBody DepartmentLocationDTO departmentLocationDTO);

    @DeleteMapping("/{locationId}")
    ResponseEntity<Void> deleteDepartmentLocation(@PathVariable("locationId") Long locationId);

    @PutMapping("/{locationId}")
    ResponseEntity<DepartmentLocation> updateDepartmentLocation(@PathVariable("locationId") Long locationId,
                                                                @RequestBody DepartmentLocationDTO departmentLocationDTO);
}
