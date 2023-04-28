package com.example.demo.rest;

import com.example.demo.dto.RelativeDTO;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/relatives")
public interface RelativeAPI {
    @GetMapping
    ResponseEntity<List<Relative>> getAllRelative();
    @GetMapping(value = "/{relativeId}")
    ResponseEntity<Optional<Relative>> findRelativeById(@PathVariable("relativeId") Long relativeId);
    @GetMapping("/fullnameorgenders")
    ResponseEntity<List<Relative>> findByFullNameOrGender(@RequestParam("fullName") String fullName,
                                                          @RequestParam("gender")Gender gender);
    @GetMapping("/fullnames")
    ResponseEntity<List<Relative>> findByFullName(@RequestParam("fullName") String fullName);
    @GetMapping("/phonenotnull")
    ResponseEntity<List<Relative>> findByPhoneNumberNotNull();
    @GetMapping("/orderbyfullnames")
    ResponseEntity<List<Relative>> findByOrderByFullName();
    @GetMapping("/notfullnames")
    ResponseEntity<List<Relative>> findByFullNameNot(@RequestParam("fullName") String fullName);
    @PostMapping(value = "/{employeeid}")
    ResponseEntity<Relative> createRelative(@PathVariable("employeeid") String employeeid,
                                             @RequestBody RelativeDTO relativeDTO);
    @DeleteMapping("/{relativeId}")
    ResponseEntity<Void> deleteRelative(@PathVariable("relativeId") Long relativeId);

    @PutMapping("/{relativeId}")
    ResponseEntity<Relative> updateRelative(@PathVariable("relativeId") Long relativeId,
                                            @RequestBody RelativeDTO relativeDTO);
}
