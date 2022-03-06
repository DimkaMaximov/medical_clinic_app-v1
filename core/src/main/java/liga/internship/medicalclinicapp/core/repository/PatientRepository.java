package liga.internship.medicalclinicapp.core.repository;

import liga.internship.medicalclinicapp.core.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
