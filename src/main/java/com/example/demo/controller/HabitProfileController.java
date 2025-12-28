package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService habitService;

    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    // Create or Update Habit
    @PostMapping
    public ResponseEntity<HabitProfile> saveHabit(@RequestBody HabitProfile habit) {
        HabitProfile saved = habitService.createOrUpdateHabit(habit);
        return ResponseEntity.ok(saved);
    }

    // Get Habit By Student Id
    @GetMapping("/{studentId}")
    public ResponseEntity<HabitProfile> getHabit(@PathVariable Long studentId) {

        Optional<HabitProfile> habit = habitService.getHabitByStudent(studentId);

        return habit.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
