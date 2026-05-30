package com.fine_x.hospitalManagement.dto;

import com.fine_x.hospitalManagement.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}
