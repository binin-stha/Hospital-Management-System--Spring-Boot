package com.fine_x.hospitalManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentResponseDto {
    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentTime;
    private String reason;
}
