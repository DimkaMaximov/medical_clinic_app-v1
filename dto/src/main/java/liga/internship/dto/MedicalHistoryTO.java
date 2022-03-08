package liga.internship.dto;

import java.time.LocalDateTime;
//import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
