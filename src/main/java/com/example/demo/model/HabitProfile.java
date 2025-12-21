package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String habits;

    public HabitProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHabits() { return habits; }
    public void setHabits(String habits) { this.habits = habits; }
}
