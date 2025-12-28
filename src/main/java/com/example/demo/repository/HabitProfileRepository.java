package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HabitProfile;

import java.util.List;

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {

    List<HabitProfile> findByStudentProfileId(Long studentId);
}
