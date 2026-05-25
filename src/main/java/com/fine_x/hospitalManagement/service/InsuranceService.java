package com.fine_x.hospitalManagement.service;


import com.fine_x.hospitalManagement.entity.Insurance;
import com.fine_x.hospitalManagement.entity.Patient;
import com.fine_x.hospitalManagement.repository.InsuranceRepository;
import com.fine_x.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient not found with Id: " + patientId));
        patient.setInsurance(insurance);

        insurance.setPatient(patient);  // Bidirectional consistency maintainence
        return patient;

    }
}

