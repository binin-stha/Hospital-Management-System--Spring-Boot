package com.fine_x.hospitalManagement;

import com.fine_x.hospitalManagement.entity.Patient;
import com.fine_x.hospitalManagement.repository.PatientRepository;
import com.fine_x.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository() {
       List<Patient> patients =  patientRepository.findAll();
        System.out.println(patients);
    }

    @Test
    public void getPatient() {
        Patient p1 = patientService.getPatientById(1L);

        System.out.println(p1);
    }
}
