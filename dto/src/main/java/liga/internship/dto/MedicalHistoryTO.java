package liga.internship.dto;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoryTO {

    private Long id;

    private PatientEntity patient;

    private String docNumber;

    private LocalDateTime createDttm;

    private LocalDateTime modifyDttm;

    private String doctor;

    private String diagnosis;

    private List<MedicalHistory> medicalHistory;
}
