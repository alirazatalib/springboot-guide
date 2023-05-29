package com.guide.springboot.repositories;

import com.guide.springboot.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Boolean existsDoctorByEmail(String email);
}
