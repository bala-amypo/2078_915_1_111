package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Original
    public String generateToken(String username) {
        return "token_" + username;
    }

    // Overload with 3 args
    public String generateToken(String username, String role, String email) {
        return "token_" + username;
    }

    // Overload with 4 args
    public String generateToken(String username, String role, String email, String id) {
        return "token_" + username;
    }
}
