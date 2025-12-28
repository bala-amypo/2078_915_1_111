package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habit")
public class HabitProfileController {

    @Autowired
    private HabitProfileService habitService;

    // Create or Update
    @PostMapping
    public ResponseEntity<HabitProfile> saveHabit(@RequestBody HabitProfile habit) {
        HabitProfile saved = habitService.createOrUpdateHabit(habit);
        return ResponseEntity.ok(saved);
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<HabitProfile>> getAll() {
        return ResponseEntity.ok(habitService.getAllHabitProfiles());
    }

    // 🔥 REQUIRED BY TEST — getHabitById(long)
    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getHabit(@PathVariable Long id) {
        Optional<HabitProfile> habit = habitService.getHabitById(id);
        return habit.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔥 REQUIRED BY TEST — getByStudent(long)
    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId) {
        Optional<HabitProfile> habit = habitService.getHabitByStudent(studentId);
        return habit.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
