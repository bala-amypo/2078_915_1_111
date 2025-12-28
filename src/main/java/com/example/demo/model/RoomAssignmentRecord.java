package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentAId;
    private String studentBId;
    private String roomNumber;

    public Long getId() {
        return id;
    }

    public String getStudentAId() {
        return studentAId;
    }

    public void setStudentAId(String studentAId) {
        this.studentAId = studentAId;
    }

    public String getStudentBId() {
        return studentBId;
    }

    public void setStudentBId(String studentBId) {
        this.studentBId = studentBId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
