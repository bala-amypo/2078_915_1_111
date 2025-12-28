package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    private final HabitProfileService habitService;

    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    // Create or Update Habit
    @PostMapping
    public ResponseEntity<HabitProfile> create(@RequestBody HabitProfile habit) {
        HabitProfile saved = habitService.createOrUpdateHabit(habit);
        return ResponseEntity.ok(saved);
    }

    // Get Habit By Student ID
    @GetMapping("/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable long studentId) {
        return habitService.getHabitByStudent(studentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Habit By Habit ID
    @GetMapping("/id/{id}")
    public ResponseEntity<HabitProfile> getById(@PathVariable long id) {
        return habitService.getHabitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
