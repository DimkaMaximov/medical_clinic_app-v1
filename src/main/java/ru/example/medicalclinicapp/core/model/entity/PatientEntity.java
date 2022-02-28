package ru.example.medicalclinicapp.core.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "patient_entity")
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    private Integer age;

    private String city;

    private String address;

    @Column (name = "birthday_dt")
    private LocalDate birthdayDt;

    @Column (name = "birthday_place")
    private String birthPlace;

    private String registration;

    @Column (name = "passport_series")
    // ! в загран и иностранном паспорте могут быть буквы, возможно String
    private Integer passportSeries;

    @Column (name = "passport_number")
    private Integer passportNumber;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "another_document")
    // ! все документы изначально задекларированы, возможно лучше Enum документов
    private String anotherDocument;
}