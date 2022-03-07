package liga.internship.dto;

import javassist.NotFoundException;
import liga.internship.medicalclinicapp.core.model.entity.Gender;
import lombok.*;
import java.time.LocalDate;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntityTO {

    @Id
    private Long id;

    private String name;

//    private Gender gender;
//    public Gender genderFromString(String gender){
//        switch (gender){
//            case "MALE": return Gender.MALE;
//            case "FEMALE": return Gender.FEMALE;
//        }
//    }

    private Integer age;

    private String city;

    private String address;

    private LocalDate birthdayDt;

    private String birthPlace;

    private String registration;

    // ! в загран и иностранном паспорте могут быть буквы
    private String passportSeries;

    private Integer passportNumber;

    private String phoneNumber;

    // ! все документы изначально задекларированы, возможно лучше Enum документов
    private String anotherDocument;
}
