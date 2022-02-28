package ru.example.medicalclinicapp.core.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table (name = "medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "patient_id")
    private PatientEntity patient;

    @Column(name = "doc_number", unique = true)
    private String docNumber;

    @Column(name = "create_dttm")
    private LocalDateTime createDttm;

    @Column(name = "modify_dttm")
    private LocalDateTime modifyDttm;

    private String doctor;

    private String diagnosis;

    @OneToMany
    @JoinColumn(name = "medical_history")
    private List<MedicalHistory> medicalHistory;
}
