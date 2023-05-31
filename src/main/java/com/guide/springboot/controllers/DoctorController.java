package com.guide.springboot.controllers;

import com.guide.springboot.dtos.DoctorDTO;
import com.guide.springboot.requests.DoctorRegistrationRequest;
import com.guide.springboot.requests.DoctorUpdateRequest;
import com.guide.springboot.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Integer id) {
        return ResponseEntity.ok(doctorService.findDoctor(id));
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveDoctor(@RequestBody DoctorRegistrationRequest doctorRegistrationRequest) {
        doctorService.saveDoctor(doctorRegistrationRequest);
        return new ResponseEntity<>("Doctor has been registered successfully!",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor with id [%s] has been deleted successfully!".formatted(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctorById(@PathVariable Integer id, @RequestBody DoctorUpdateRequest doctorUpdateRequest) {
        doctorService.updateDoctor(id, doctorUpdateRequest);
        return ResponseEntity.ok("Doctor with id [%s] has been updated successfully!".formatted(id));
    }
}
