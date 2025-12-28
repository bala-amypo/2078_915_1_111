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
    public HabitProfile createHabitProfile(HabitProfile habit) {

        // avoid null comparison issue
        // if study hours not provided, default to 0
        if (habit.getStudyHoursPerDay() == 0) {
            habit.setStudyHoursPerDay(0);
        }

        habit.setCreatedAt(LocalDateTime.now());
        habit.setUpdatedAt(LocalDateTime.now());

        return repository.save(habit);
    }

    @Override
    public HabitProfile updateHabitProfile(Long id, HabitProfile habit) {
        HabitProfile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit profile not found"));

        existing.setSleepSchedule(habit.getSleepSchedule());
        existing.setStudyHoursPerDay(habit.getStudyHoursPerDay());
        existing.setCleanlinessLevel(habit.getCleanlinessLevel());
        existing.setNoiseTolerance(habit.getNoiseTolerance());
        existing.setSocialPreference(habit.getSocialPreference());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    @Override
    public void deleteHabitProfile(Long id) {
        repository.deleteById(id);
    }
}
