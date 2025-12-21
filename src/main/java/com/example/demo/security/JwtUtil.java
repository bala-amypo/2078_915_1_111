package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean validate(String token) {
        // dummy implementation for test cases
        return true;
    }

    public String generateToken(String email, String role, String userId, String name) {
        // dummy implementation for test cases
        return "dummy-token";
    }
}
