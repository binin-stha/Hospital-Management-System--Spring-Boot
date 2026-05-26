package com.fine_x.hospitalManagement.service;


import com.fine_x.hospitalManagement.entity.Appointment;
import com.fine_x.hospitalManagement.entity.Doctor;
import com.fine_x.hospitalManagement.entity.Patient;
import com.fine_x.hospitalManagement.repository.AppointmentRepository;
import com.fine_x.hospitalManagement.repository.DoctorRepository;
import com.fine_x.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointmnet should not have ID");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointmentList().add(appointment); // to maintain bidirectional consistency

        return appointmentRepository.save(appointment);
    }




}
