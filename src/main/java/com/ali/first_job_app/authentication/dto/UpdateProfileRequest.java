package com.ali.first_job_app.authentication.dto;

import jakarta.validation.constraints.Email;
public class UpdateProfileRequest {

    @Email(message = "Email should be valid")
    private String email;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructors
    public UpdateProfileRequest() {}

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
