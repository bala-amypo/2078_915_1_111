package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    @PostMapping
    public void createHabit() {
        // method definition only
    }

    @GetMapping("/{id}")
    public void getHabitById(@PathVariable Long id) {
        // method definition only
    }

    @PutMapping("/{id}")
    public void updateHabit(@PathVariable Long id) {
        // method definition only
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        // method definition only
    }
}
