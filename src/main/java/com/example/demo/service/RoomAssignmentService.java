package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    // Create or save assignment
    RoomAssignmentRecord assignRoom(RoomAssignmentRecord record);

    // Get assignment by ID
    RoomAssignmentRecord getAssignmentById(Long id);

    // Get all assignments
    List<RoomAssignmentRecord> getAllAssignments();

    // Get assignments for a specific student
    List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId);

    // Delete assignment
    void deleteAssignment(Long id);
}
