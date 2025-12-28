package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        return habitRepo.save(habit);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return habitRepo.findAll();
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return habitRepo.findById(id);
    }

    @Override
    public Optional<HabitProfile> getHabitByStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId);
    }

    @Override
    public void deleteHabit(Long id) {
        habitRepo.deleteById(id);
    }
}
