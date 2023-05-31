package com.guide.springboot.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DoctorRegistrationRequest(
        @NotEmpty(message = "First name must not be null or empty!")
        @Size(min = 3,message = "First name should have at least 3 characters.")
        String firstName,
        @NotEmpty(message = "Last name must not be null or empty!")
        @Size(min = 3, message = "Last name should have at least 3 characters.")
        String lastName,
        @NotEmpty(message = "Email must not be null or empty!")
        @Email(message = "Email must be valid!")
        String email,
        @NotEmpty(message = "Password must not be null or empty!")
        String password,
        @NotEmpty(message = "Mobile no. must not be null or empty!")
        String mobileNo,
        @NotEmpty(message = "Address must not be null or empty!")
        String address,
        @NotEmpty(message = "Specialization must not be null or empty!")
        String specialization
) {
}
