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

    // CREATE or SAVE
    @Override
    public HabitProfile saveHabit(HabitProfile habit) {

        // If entity already has timestamps, do not force setCreatedAt() (it caused errors earlier)
        habit.setUpdatedAt(LocalDateTime.now());

        return repository.save(habit);
    }

    // UPDATE
    @Override
    public HabitProfile updateHabit(Long id, HabitProfile habit) {
        HabitProfile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        existing.setSleepSchedule(habit.getSleepSchedule());
        existing.setStudyHoursPerDay(habit.getStudyHoursPerDay());
        existing.setCleanlinessLevel(habit.getCleanlinessLevel());
        existing.setNoiseTolerance(habit.getNoiseTolerance());
        existing.setSocialPreference(habit.getSocialPreference());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    // GET BY ID
    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    // GET BY STUDENT
    @Override
    public Optional<HabitProfile> getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    // GET ALL
    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    // DELETE
    @Override
    public void deleteHabit(Long id) {
        repository.deleteById(id);
    }
}
