package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "test-token";
    }

    // OVERLOADED METHOD (to satisfy controller)
    public String generateToken(String username, String role, String email, String id) {
        return "test-token";
    }

    public String extractUsername(String token) {
        return "test-user";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
