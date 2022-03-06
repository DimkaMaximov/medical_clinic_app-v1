package liga.internship.medicalclinicapp.core.service.impl;

import liga.internship.medicalclinicapp.core.model.entity.PatientEntity;
import liga.internship.medicalclinicapp.core.repository.PatientRepository;
import liga.internship.medicalclinicapp.core.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }


    @Override
    public PatientEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PatientEntity> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(PatientEntity entity) {
        repository.save(entity);
    }

    @Override
    public PatientEntity create(PatientEntity entity) {
        return repository.save(entity);
    }
}
