package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private double score;

    public void setStudentA(StudentProfile studentA) { this.studentA = studentA; }
    public void setStudentB(StudentProfile studentB) { this.studentB = studentB; }
    public void setScore(double score) { this.score = score; }

    public double getScore() { return score; }
}
