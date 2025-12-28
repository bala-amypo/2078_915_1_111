package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @PostMapping
    public void createMatch() {
        // method definition only
    }

    @GetMapping("/{id}")
    public void getMatchById(@PathVariable Long id) {
        // method definition only
    }
}
