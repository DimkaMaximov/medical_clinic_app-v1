package liga.internship.medicalclinicapp.core.controller.rest;

import liga.internship.medicalclinicapp.core.model.entity.MedicalHistory;
import liga.internship.medicalclinicapp.core.service.MedicalHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical/history")
public class MedicalHistoryController {

    MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistory> getById(@PathVariable("id") Long id){
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        MedicalHistory history = service.findById(id);
        if (history == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MedicalHistory>> getAll(){
        List<MedicalHistory> historyList = service.findAll();
        if(historyList.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MedicalHistory> create(@RequestBody MedicalHistory history){
        if(history == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.create(history);
        return new ResponseEntity<>(history, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<MedicalHistory> update(@RequestBody MedicalHistory history){
        if (history == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.update(history);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalHistory> delete (@PathVariable("id") Long id){
        MedicalHistory history = service.findById(id);
        if(history == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
