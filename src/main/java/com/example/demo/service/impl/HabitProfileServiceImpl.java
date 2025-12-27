package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {
    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() != null && habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours must be non-negative");
        }
        
        Optional<HabitProfile> existing = repository.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            HabitProfile existingHabit = existing.get();
            existingHabit.setStudyHoursPerDay(habit.getStudyHoursPerDay());
            existingHabit.setSleepSchedule(habit.getSleepSchedule());
            existingHabit.setCleanlinessLevel(habit.getCleanlinessLevel());
            existingHabit.setNoiseTolerance(habit.getNoiseTolerance());
            existingHabit.setSocialPreference(habit.getSocialPreference());
            existingHabit.setUpdatedAt(LocalDateTime.now());
            return repository.save(existingHabit);
        }
        
        habit.setUpdatedAt(LocalDateTime.now());
        return repository.save(habit);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId)
            .orElseThrow(() -> new RuntimeException("Habit profile not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}