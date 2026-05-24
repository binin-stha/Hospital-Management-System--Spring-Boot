package com.fine_x.hospitalManagement;

import com.fine_x.hospitalManagement.entity.Patient;
import com.fine_x.hospitalManagement.repository.PatientRepository;
import com.fine_x.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

    @Test
    public void testTranctionalMethods() {
//        Patient patient = patientRepository.findByName("Roshan Neupane");
//        System.out.println(patient);
//
//        Patient p2 = patientRepository.findByBirthDate(LocalDate.of(2003,2,18));
//        System.out.println(p2);
//
//        List<Patient> p3 = patientRepository.findByBirthDateOrEmail(LocalDate.of(1995,1,17), "kabita12@gmail.com");
//        for (Patient biramis: p3) {
//            System.out.println(biramis);
//        }

//        List<Patient> patientList = patientRepository.findByBirthDateBetween(LocalDate.of(1995,1,17), LocalDate.of(2004,4,9));
//        for (Patient p: patientList) {
//            System.out.println(p);
//        }

//        List<Patient> patientList = patientRepository.findByNameContaining("i");
//        for (Patient p: patientList) {
//            System.out.println(p);
//        }

        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("i");
        for (Patient p: patientList) {
            System.out.println(p);
        }
    }
}
