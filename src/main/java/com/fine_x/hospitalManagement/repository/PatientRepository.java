package com.fine_x.hospitalManagement.repository;

import com.fine_x.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.fine_x.hospitalManagement.entity.Patient;
import com.fine_x.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Query("SELECT p from Patient p where p.bloodGroup = ?1")   // JPQL - Jakarta Persistence Query Language
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBirthAfterDate(LocalDate birthDate);

//    @Query("SELECT p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    @Query("""
        SELECT new com.fine_x.hospitalManagement.dto.BloodGroupCountResponseEntity(
            p.bloodGroup,
            COUNT(p)
        )
        FROM Patient p
        GROUP BY p.bloodGroup
    """)
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

//    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> findAllPatients();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = ?1 where p.id = ?2")
    int updateNameWithID(@Param("name") String name, @Param("id") Long id);

//    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointmentList a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointmentList")
    List<Patient> findAllPatientsWithAppointment();

}
