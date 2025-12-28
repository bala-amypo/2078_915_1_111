package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentA;
    private String studentB;
    private double score;

    public Long getId() { return id; }
    public String getStudentA() { return studentA; }
    public void setStudentA(String studentA) { this.studentA = studentA; }
    public String getStudentB() { return studentB; }
    public void setStudentB(String studentB) { this.studentB = studentB; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
