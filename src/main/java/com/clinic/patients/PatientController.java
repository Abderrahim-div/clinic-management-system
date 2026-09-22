package com.clinic.patients;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clinic.patients.PatientRepository;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController{
    private PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    @GetMapping
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id){
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}   
