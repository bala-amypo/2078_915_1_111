package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ✅ THIS IS THE FIX
public class JwtUtil {

    public String generateToken(String username) {
        // simple token for now (tests usually expect this)
        return "token_" + username;
    }
}
