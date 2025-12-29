package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        boolean success = authService.login(request.getUsername(), request.getPassword());
        if (success) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Invalid Credentials");
    }

    // 👑 CREATE ADMIN
    @PostMapping("/admin")
    public ResponseEntity<String> createAdmin(@RequestBody AuthRequest request) {
        authService.createUser(request, "ADMIN");
        return ResponseEntity.ok("Admin Created Successfully");
    }

    // 👨‍🎓 REGISTER NORMAL USER  (THIS FIXES YOUR TEST ERROR)
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        authService.createUser(request, "USER");
        return ResponseEntity.ok("User Registered Successfully");
    }
}
