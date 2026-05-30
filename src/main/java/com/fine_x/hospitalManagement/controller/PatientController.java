package com.fine_x.hospitalManagement.controller;

import com.fine_x.hospitalManagement.dto.AppointmentResponseDto;
import com.fine_x.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.fine_x.hospitalManagement.dto.PatientResponseDto;
import com.fine_x.hospitalManagement.service.AppointmentService;
import com.fine_x.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestParam CreateAppointmentRequestDto createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/appointments")
    public ResponseEntity<PatientResponseDto> getPatientProfile() {
        Long patientId = 4L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));

    }


}
