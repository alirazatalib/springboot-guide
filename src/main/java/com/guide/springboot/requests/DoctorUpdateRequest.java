package com.guide.springboot.requests;

public record DoctorUpdateRequest(
        String firstName,
        String lastName,
        String mobileNo,
        String address,
        String specialization) {
}
