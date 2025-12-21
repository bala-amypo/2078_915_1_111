package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean validate(String token) {
        return true;
    }

    public String generateToken(String email, String role, String userId, String name) {
        return "dummy-token";
    }
}
