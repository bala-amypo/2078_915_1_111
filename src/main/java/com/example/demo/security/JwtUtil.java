package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "test-token";
    }

    public String extractUsername(String token) {
        return "test-user";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
