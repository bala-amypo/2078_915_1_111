package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import com.example.demo.dto.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
}
