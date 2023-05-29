package com.guide.springboot.services.impl;

import com.guide.springboot.dtos.DoctorDTO;
import com.guide.springboot.entities.Doctor;
import com.guide.springboot.exceptions.DuplicateResourceException;
import com.guide.springboot.exceptions.ResourceNotFoundException;
import com.guide.springboot.mappers.DoctorDTOMapper;
import com.guide.springboot.repositories.DoctorRepository;
import com.guide.springboot.requests.DoctorRegistrationRequest;
import com.guide.springboot.requests.DoctorUpdateRequest;
import com.guide.springboot.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorDTOMapper doctorDTOMapper;

    @Override
    public void saveDoctor(DoctorRegistrationRequest doctorRegistrationRequest) {
        String email = doctorRegistrationRequest.email();
        if (doctorRepository.existsDoctorByEmail(email)) {
            throw new DuplicateResourceException("Email already taken!");
        }
        Doctor doctor = new Doctor(
                doctorRegistrationRequest.firstName(),
                doctorRegistrationRequest.lastName(),
                doctorRegistrationRequest.email(),
                doctorRegistrationRequest.password(),
                doctorRegistrationRequest.mobileNo(),
                doctorRegistrationRequest.address(),
                doctorRegistrationRequest.specialization());

        doctorRepository.save(doctor);
    }

    @Override
    public DoctorDTO findDoctor(Integer id) {
        return doctorRepository.findById(id).
                map(doctorDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with id [%s] not found".formatted(id)));
    }

    @Override
    public List<DoctorDTO> findAllDoctors() {
        return
                doctorRepository.findAll()
                        .stream()
                        .map(doctorDTOMapper)
                        .collect(Collectors.toList());
    }

    @Override
    public void updateDoctor(Integer id, DoctorUpdateRequest doctorUpdateRequest) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with id [%s] not found".formatted(id)));

        boolean hasChanges = false;

        if (!doctor.getFirstName().equals(doctorUpdateRequest.firstName()) && !doctorUpdateRequest.firstName().isBlank()) {
            doctor.setFirstName(doctorUpdateRequest.firstName());
            hasChanges = true;
        }
        if (!doctor.getLastName().equals(doctorUpdateRequest.lastName()) && !doctorUpdateRequest.lastName().isBlank()) {
            doctor.setLastName(doctorUpdateRequest.lastName());
            hasChanges = true;
        }
        if (!doctor.getAddress().equals(doctorUpdateRequest.address()) && !doctorUpdateRequest.address().isBlank()) {
            doctor.setAddress(doctorUpdateRequest.address());
            hasChanges = true;
        }
        if (!doctor.getMobileNo().equals(doctorUpdateRequest.mobileNo()) && !doctorUpdateRequest.mobileNo().isBlank()) {
            doctor.setMobileNo(doctorUpdateRequest.mobileNo());
            hasChanges = true;
        }
        if (!doctor.getSpecialization().equals(doctorUpdateRequest.specialization()) && !doctorUpdateRequest.specialization().isBlank()) {
            doctor.setSpecialization(doctorUpdateRequest.specialization());
            hasChanges = true;
        }
        if (hasChanges) {
            doctorRepository.save(doctor);
        }
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with id [%s] not found".formatted(id)));
        doctorRepository.deleteById(id);
    }
}
