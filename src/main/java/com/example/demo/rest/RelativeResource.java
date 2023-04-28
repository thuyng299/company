package com.example.demo.rest;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import com.example.demo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RelativeResource implements RelativeAPI{
    private final RelativeService relativeService;
    @Override
    public ResponseEntity<List<Relative>> getAllRelative(){
        return ResponseEntity.ok(relativeService.getAllRelative());
    }
    public ResponseEntity<Optional<Relative>> findRelativeById(Long relativeId){
        return ResponseEntity.ok(relativeService.findRelativeById(relativeId));
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullNameOrGender(String fullName, Gender gender){
        return ResponseEntity.ok(relativeService.findByFullNameOrGender(fullName, gender));
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullName(String fullName){
        return ResponseEntity.ok(relativeService.findByFullName(fullName));
    }
    @Override
    public ResponseEntity<List<Relative>> findByPhoneNumberNotNull(){
        return ResponseEntity.ok(relativeService.findByPhoneNumberNotNull());
    }
    @Override
    public ResponseEntity<List<Relative>> findByOrderByFullName(){
        return ResponseEntity.ok(relativeService.findByOrderByFullName());
    }
    @Override
    public ResponseEntity<List<Relative>> findByFullNameNot(String fullName){
        return ResponseEntity.ok(relativeService.findByFullNameNot(fullName));
    }
    @Override
    public ResponseEntity<Relative> createRelative(String employeeid, RelativeDTO relativeDTO) {
        Relative relative = relativeService.createRelative(relativeDTO, employeeid);
        return ResponseEntity.created(URI.create("/api/relatives" + relative.getId())).body(relative);
    }
    @Override
    public ResponseEntity<Void> deleteRelative(Long relativeId){
        relativeService.deleteRelative(relativeId);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<Relative> updateRelative(Long relativeId, RelativeDTO relativeDTO){
        Relative result = relativeService.updateRelative(relativeId, relativeDTO);
        return ResponseEntity.ok().body(result);
    }
}
