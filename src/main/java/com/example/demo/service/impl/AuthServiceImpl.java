package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userRepo;

    public AuthServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public AuthResponse register(AuthRequest request) {

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        userRepo.save(user);

        return new AuthResponse(null, user.getId(), user.getEmail(), user.getRole());
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        UserAccount user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
