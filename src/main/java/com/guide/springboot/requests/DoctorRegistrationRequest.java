package com.guide.springboot.requests;

public record DoctorRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String mobileNo,
        String address,
        String specialization
) {
}
