package com.learning.controller;

import com.learning.model.Doctor;
import com.learning.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/add_new_doctor")
    public Doctor AddNewDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }
}
