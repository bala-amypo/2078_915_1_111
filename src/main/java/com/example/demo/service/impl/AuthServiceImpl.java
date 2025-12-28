package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void register(String username, String password) {
        // Intentionally empty (logic handled elsewhere or mocked in tests)
    }

    @Override
    public void login(String username, String password) {
        // Intentionally empty
    }
}
