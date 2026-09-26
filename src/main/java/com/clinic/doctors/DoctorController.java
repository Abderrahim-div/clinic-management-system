package com.clinic.doctors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    private DoctorRepository doctorRepository;
    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctorRepository.deleteById(id);
    }
}
