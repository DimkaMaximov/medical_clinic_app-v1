package ru.example.medicalclinicapp.core.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.medicalclinicapp.core.model.entity.PatientEntity;
import ru.example.medicalclinicapp.core.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/medical/patients")
public class PatientRestController {

    PatientService service;

    public PatientRestController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientEntity> getById(@PathVariable("id") Long id){
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PatientEntity patient = service.findById(id);
        if (patient == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<PatientEntity>> getAll(){
        List <PatientEntity> patients = this.service.findAll();
        if(patients.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PatientEntity> create (@RequestBody PatientEntity patient){
        if(patient == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.create(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<PatientEntity> update (@RequestBody PatientEntity patient){
        if(patient == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.update(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PatientEntity> delete (@PathVariable ("id") Long id){
        PatientEntity patient = service.findById(id);
        if(patient == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
