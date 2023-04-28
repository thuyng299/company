package com.example.demo.repository;

import com.example.demo.entity.Gender;
import com.example.demo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Long> {
    List<Relative> findByFullNameOrGender(String fullName, Gender gender);
    List<Relative> findByFullName(String fullName);
    List<Relative> findByPhoneNumberNotNull();
    List<Relative> findByOrderByFullName();
    List<Relative> findByFullNameNot(String fullName);
}
