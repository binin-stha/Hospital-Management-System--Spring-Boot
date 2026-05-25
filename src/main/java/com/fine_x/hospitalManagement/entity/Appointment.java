package com.fine_x.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
}
