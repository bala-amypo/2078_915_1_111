package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord createAssignment(Long studentAId, Long studentBId);

    RoomAssignmentRecord getAssignmentById(Long id);

    List<RoomAssignmentRecord> getAllAssignments();

    RoomAssignmentRecord updateStatus(Long id, String status);

    void deleteAssignment(Long id);
}
