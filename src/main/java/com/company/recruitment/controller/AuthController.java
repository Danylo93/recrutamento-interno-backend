package com.company.recruitment.controller;

import com.company.recruitment.dto.LoginRequest;
import com.company.recruitment.dto.RegisterRequest;
import com.company.recruitment.model.User;
import com.company.recruitment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/login")
    public String login(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request.getUsername(), request.getPassword());
        if (token != null) {
            return token;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @PostMapping("/api/auth/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword());
    }
}
