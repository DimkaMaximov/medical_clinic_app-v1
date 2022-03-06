package liga.internship.medicalclinicapp.core.service.impl;

import liga.internship.medicalclinicapp.core.model.entity.MedicalHistory;
import liga.internship.medicalclinicapp.core.repository.MedicalHistoryRepository;
import liga.internship.medicalclinicapp.core.service.MedicalHistoryService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    MedicalHistoryRepository repository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicalHistory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MedicalHistory> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(MedicalHistory entity) {
        repository.save(entity);
    }

    @Override
    public MedicalHistory create(MedicalHistory entity) {
        return repository.save(entity);
    }
}
