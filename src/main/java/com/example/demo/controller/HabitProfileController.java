package com.example.demo.controller;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService habitService;

    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/{studentId}")
    public HabitProfile createOrUpdate(
            @PathVariable Long studentId,
            @RequestBody HabitProfileDto dto) {
        return habitService.create(studentId, dto);
    }

    @GetMapping("/{studentId}")
    public HabitProfile getForStudent(@PathVariable Long studentId) {
        return habitService.getForStudent(studentId);
    }
}
