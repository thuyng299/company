package com.example.demo.dto;

import com.example.demo.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelativeDTO {
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String relationship;
    private String firstName;
    private String lastName;

}
