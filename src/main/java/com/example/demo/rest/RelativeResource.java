package com.example.demo.rest;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.dto.RelativeOfEmpWithMinSalaryInDeptDTO;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import com.example.demo.exception.ResponseException;
import com.example.demo.serviceimpl.RelativeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RelativeResource implements RelativeAPI{
    private final RelativeServiceImpl relativeServiceImpl;
    @Override
    public ResponseEntity<List<Relative>> getAllRelative(){
        return ResponseEntity.ok(relativeServiceImpl.getAllRelative());
    }
    public ResponseEntity<Optional<Relative>> findRelativeById(Long relativeId){
        return ResponseEntity.ok(relativeServiceImpl.findRelativeById(relativeId));
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullNameOrGender(String fullName, Gender gender){
        return ResponseEntity.ok(relativeServiceImpl.findByFullNameOrGender(fullName, gender));
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullName(String fullName){
        return ResponseEntity.ok(relativeServiceImpl.findByFullName(fullName));
    }
    @Override
    public ResponseEntity<List<Relative>> findByPhoneNumberNotNull(){
        return ResponseEntity.ok(relativeServiceImpl.findByPhoneNumberNotNull());
    }
    @Override
    public ResponseEntity<List<Relative>> findByOrderByFullName(){
        return ResponseEntity.ok(relativeServiceImpl.findByOrderByFullName());
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullNameNot(String fullName){
        return ResponseEntity.ok(relativeServiceImpl.findByFullNameNot(fullName));
    }
    @Override
    public ResponseEntity<Relative> createRelative(String employeeid, RelativeDTO relativeDTO) {
        Relative relative = relativeServiceImpl.createRelative(relativeDTO, employeeid);
        return ResponseEntity.created(URI.create("/api/relatives" + relative.getId())).body(relative);
    }
    @Override
    public ResponseEntity<Void> deleteRelative(Long relativeId){
        relativeServiceImpl.deleteRelative(relativeId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Relative> updateRelative(Long relativeId, RelativeDTO relativeDTO){
        Relative result = relativeServiceImpl.updateRelative(relativeId, relativeDTO);
        return ResponseEntity.ok().body(result);
    }
    @Override
    public ResponseEntity<List<RelativeDTO>> getRelativeByGenderAndEmployeeId(){
        try {
            return ResponseEntity.ok().body(relativeServiceImpl.getRelativeByGenderAndEmployeeId());
        }catch (ResponseException e){
            throw e;
        }
    }
    @Override
    public ResponseEntity<List<RelativeOfEmpWithMinSalaryInDeptDTO>> getRelativeOfEmpWithMinSalaryInDept(){
        try {
            return ResponseEntity.ok().body(relativeServiceImpl.getRelativeOfEmpWithMinSalaryInDept());
        }catch (ResponseException e){
            throw e;
        }
    }
}
