package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createHabit(HabitProfile habit) {

        // Prevent null compare issue
        if (habit.getStudyHoursPerDay() == null) {
            habit.setStudyHoursPerDay(0);
        }

        habit.setCreatedAt(LocalDateTime.now());
        habit.setUpdatedAt(LocalDateTime.now());
        return repository.save(habit);
    }

    @Override
    public HabitProfile updateHabit(Long id, HabitProfile habit) {
        HabitProfile existingHabit = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit profile not found"));

        if (habit.getSleepSchedule() != null)
            existingHabit.setSleepSchedule(habit.getSleepSchedule());

        if (habit.getStudyHoursPerDay() != null)
            existingHabit.setStudyHoursPerDay(habit.getStudyHoursPerDay());

        if (habit.getCleanlinessLevel() != null)
            existingHabit.setCleanlinessLevel(habit.getCleanlinessLevel());

        if (habit.getNoiseTolerance() != null)
            existingHabit.setNoiseTolerance(habit.getNoiseTolerance());

        if (habit.getSocialPreference() != null)
            existingHabit.setSocialPreference(habit.getSocialPreference());

        existingHabit.setUpdatedAt(LocalDateTime.now());
        return repository.save(existingHabit);
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit profile not found"));
    }

    @Override
    public List<HabitProfile> getAllHabits() {
        return repository.findAll();
    }
}
