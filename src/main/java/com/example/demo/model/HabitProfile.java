package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String habits;

    @OneToOne
    private StudentProfile student;

    public Long getId() { return id; }
    public String getHabits() { return habits; }
    public void setHabits(String habits) { this.habits = habits; }
    public StudentProfile getStudent() { return student; }
    public void setStudent(StudentProfile student) { this.student = student; }
}
