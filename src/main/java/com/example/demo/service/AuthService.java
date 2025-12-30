package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Create Admin
    @PostMapping("/admin")
    public ResponseEntity<String> createAdmin(@RequestBody AuthRequest request) {
        String result = authService.registerAdmin(request);
        return ResponseEntity.ok(result);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        String result = authService.login(request);
        return ResponseEntity.ok(result);
    }
}
