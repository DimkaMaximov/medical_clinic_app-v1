package ru.example.medicalclinicapp.core.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.example.medicalclinicapp.core.model.entity.MedicalHistory;
import ru.example.medicalclinicapp.core.repository.MedicalHistoryRepository;
import ru.example.medicalclinicapp.core.service.MedicalHistoryService;

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
