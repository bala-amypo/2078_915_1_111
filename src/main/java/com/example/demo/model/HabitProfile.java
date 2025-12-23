package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile student;

    private int cleanlinessLevel;
    private int noisePreference;
    private boolean smoking;

    public StudentProfile getStudent() { return student; }
    public int getCleanlinessLevel() { return cleanlinessLevel; }

    public void setStudent(StudentProfile student) { this.student = student; }
    public void setCleanlinessLevel(int cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
}
