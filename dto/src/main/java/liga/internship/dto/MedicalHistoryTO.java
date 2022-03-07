package liga.internship.dto;

import java.time.LocalDateTime;
import java.util.List;

import liga.internship.medicalclinicapp.core.model.entity.MedicalHistory;
import liga.internship.medicalclinicapp.core.model.entity.PatientEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoryTO {

    @Id
    private Long id;

    private Long patientId;

    private String docNumber;

    private LocalDateTime createDttm;

    private LocalDateTime modifyDttm;

    private String doctor;

    private String diagnosis;

    //private List<MedicalHistory> medicalHistory;
}
