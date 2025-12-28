package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public void login() {
        // method definition only
    }

    @PostMapping("/register")
    public void register() {
        // method definition only
    }
}
