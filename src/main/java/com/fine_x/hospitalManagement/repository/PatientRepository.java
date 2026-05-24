package com.fine_x.hospitalManagement.repository;

import com.fine_x.hospitalManagement.entity.Patient;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate birthDate);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByNameContaining(String query);
    List<Patient> findByNameContainingOrderByIdDesc(String query);



}
