package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private int age;
    private boolean active;

    // ---- REQUIRED ----
    public boolean isActive() {
        return active;
    }

    // ---- REQUIRED (for RoomAssignmentServiceImpl) ----
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // other getters/setters
}
