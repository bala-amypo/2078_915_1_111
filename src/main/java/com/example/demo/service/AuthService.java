package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String registerAdmin(AuthRequest request) {
        return "Admin Registered: " + request.getUsername();
    }

    public String login(AuthRequest request) {
        return "Login successful for: " + request.getUsername();
    }
}
