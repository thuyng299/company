package com.example.demo.serviceimpl;

import com.example.demo.dto.DepartmentLocationDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.exception.DemoException;
import com.example.demo.mapper.DepartmentLocationMapper;
import com.example.demo.repository.DepartmentLocationRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentLocationServiceImpl implements DepartmentLocationService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentLocationRepository departmentLocationRepository;
    public List<DepartmentLocation> getAllDepartmentLocation(){
        return departmentLocationRepository.findAll();
    }

    public Optional<DepartmentLocation> findDepartmentLocationById(Long locationId){
        return departmentLocationRepository.findById(locationId);
    }
    public List<DepartmentLocation> findByLocation(String location){
        return departmentLocationRepository.findByLocation(location);
    }
    public List<DepartmentLocation> findByLocationIsNull(){
        return departmentLocationRepository.findByLocationIsNull();
    }
    public List<DepartmentLocation> findByOrderByLocationDesc(){
        return departmentLocationRepository.findByOrderByLocationDesc();
    }
    public List<DepartmentLocation> findByLocationIgnoreCase(String location){
        return departmentLocationRepository.findByLocationIgnoreCase(location);
    }
    public List<DepartmentLocation> findByLocationNot(String location){
        return departmentLocationRepository.findByLocationNot(location);
    }
    public DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long deptid){
        Optional<Department> department = departmentRepository.findById(deptid);

        DepartmentLocation departmentLocation = new DepartmentLocation();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        if (department.isPresent())
            departmentLocation.setDepartment(department.get());
        return departmentLocationRepository.save(departmentLocation);
    }
    public void deleteDepartmentLocation(Long locationId){
        departmentLocationRepository.deleteById(locationId);
    }
    public DepartmentLocation updateDepartmentLocation(Long locationId, DepartmentLocationDTO departmentLocationDTO){
        Optional<DepartmentLocation> departmentLocation = departmentLocationRepository.findById(locationId);
        DepartmentLocation updateDepartmentLocation = departmentLocation.get();
        updateDepartmentLocation.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(updateDepartmentLocation);
    }
    @Override
    public List<DepartmentLocationDTO> getLocationOfDepartment(Long id){
        log.info("find location of department id {}", id);
        List<DepartmentLocation> departmentLocations = departmentLocationRepository.getLocationOfDepartment(id);
        if (id < 0){
            throw DemoException.badRequest("InvalidDepartmentId", "ID cannot be negative");
        }
        if (departmentLocations.isEmpty()){
            throw DemoException.DepartmentLocationNotFound();
        }
        return DepartmentLocationMapper.INSTANCE.toDtos(departmentLocations);
    }
    @Override
    public List<DepartmentLocationDTO> getLocationByNameAndDeptName(){
        log.info("find location by location name and department name");
        List<DepartmentLocation> departmentLocations = departmentLocationRepository.getLocationByNameAndDeptName();
        if (departmentLocations.isEmpty()){
            throw DemoException.DepartmentLocationNotFound();
        }
        return DepartmentLocationMapper.INSTANCE.toDtos(departmentLocations);
    }


}
