package com.guide.springboot.services;

import com.guide.springboot.dtos.DoctorDTO;
import com.guide.springboot.requests.DoctorRegistrationRequest;
import com.guide.springboot.requests.DoctorUpdateRequest;

import java.util.List;

public interface DoctorService {
    void saveDoctor(DoctorRegistrationRequest doctorRegistrationRequest);

    DoctorDTO findDoctor(Integer id);

    List<DoctorDTO> findAllDoctors();

    void updateDoctor(Integer id, DoctorUpdateRequest doctorUpdateRequest);

    void deleteDoctor(Integer id);
}
