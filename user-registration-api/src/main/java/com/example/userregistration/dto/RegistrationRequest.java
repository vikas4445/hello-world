package com.example.userregistration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Add validation annotations later if needed, e.g., @NotBlank, @Email, @Size
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String email;
    private String password;

    // Lombok will generate getters, setters, constructors, toString, etc.
}
