package com.example.userregistration.controller;

import com.example.userregistration.dto.RegistrationRequest;
import com.example.userregistration.model.User;
import com.example.userregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Import validation if you add it to DTO, e.g. import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        // Basic validation example (can be enhanced with @Valid and validation annotations in DTO)
        if (registrationRequest.getEmail() == null || registrationRequest.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required.");
        }
        if (registrationRequest.getPassword() == null || registrationRequest.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password is required.");
        }

        User newUser = new User();
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPassword(registrationRequest.getPassword());

        User registeredUser = userService.registerUser(newUser);

        // Decide what to return. For example, just a success message or the created user (without password).
        // For now, returning a simple success message.
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully. ID: " + registeredUser.getId());
    }
}
