package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
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

        // JwtUtil requires 4 parameters (username, role, firstname, lastname)
        String token = jwtUtil.generateToken(
                request.getUsername(),
                "USER",
                "DEFAULT",
                "USER"
        );

        return ResponseEntity.ok(token);
    }

    @PostMapping("/admin")
    public ResponseEntity<String> adminLogin(@RequestBody AuthRequest request) {

        String token = jwtUtil.generateToken(
                request.getUsername(),
                "ADMIN",
                "ADMIN",
                "USER"
        );

        return ResponseEntity.ok(token);
    }
}
