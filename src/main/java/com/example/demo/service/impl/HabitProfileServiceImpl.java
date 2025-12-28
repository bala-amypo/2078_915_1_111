package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitProfileRepository;

    public HabitProfileServiceImpl(HabitProfileRepository habitProfileRepository) {
        this.habitProfileRepository = habitProfileRepository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {

        // If student already has a habit profile → update instead of new insert
        Optional<HabitProfile> existing = habitProfileRepository.findByStudentId(habit.getStudentId());

        if (existing.isPresent()) {
            HabitProfile dbHabit = existing.get();

            dbHabit.setSleepSchedule(habit.getSleepSchedule());
            dbHabit.setStudyHoursPerDay(habit.getStudyHoursPerDay());
            dbHabit.setCleanlinessLevel(habit.getCleanlinessLevel());
            dbHabit.setNoiseTolerance(habit.getNoiseTolerance());
            dbHabit.setSocialPreference(habit.getSocialPreference());

            return habitProfileRepository.save(dbHabit);
        }

        return habitProfileRepository.save(habit);
    }

    @Override
    public Optional<HabitProfile> getHabitByStudent(Long studentId) {
        return habitProfileRepository.findByStudentId(studentId);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return habitProfileRepository.findAll();
    }

    @Override
    public void deleteHabit(Long id) {
        habitProfileRepository.deleteById(id);
    }
}
