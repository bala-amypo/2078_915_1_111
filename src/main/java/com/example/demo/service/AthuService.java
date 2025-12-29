package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }

    public void createUser(AuthRequest req, String role) {
        System.out.println("User created: " + req.getUsername() + " Role: " + role);
    }
}
