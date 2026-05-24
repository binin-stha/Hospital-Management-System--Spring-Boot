package com.fine_x.hospitalManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    private LocalDate birthdate;

    private String email;

    private String gender;

//    @Override
//    public String toString() {
//        return "Patient{" + "id=" + id + ", name='" + name + '\'' + ", birthdate=" + birthdate + ", email='" + email + '\'' + ", gender='" + gender + '\'' + '}';
//    }
}
