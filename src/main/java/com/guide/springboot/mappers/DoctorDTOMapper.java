package com.guide.springboot.mappers;

import com.guide.springboot.dtos.DoctorDTO;
import com.guide.springboot.entities.Doctor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DoctorDTOMapper implements Function<Doctor, DoctorDTO> {
    @Override
    public DoctorDTO apply(Doctor doctor) {
        return new DoctorDTO(
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getMobileNo(),
                doctor.getAddress(),
                doctor.getSpecialization()
        );
    }
}
