package com.guide.springboot.dtos;

public record DoctorDTO (
        String firstName,
        String lastName,
        String email,
        String mobileNo,
        String address,
        String specialization
){
}
