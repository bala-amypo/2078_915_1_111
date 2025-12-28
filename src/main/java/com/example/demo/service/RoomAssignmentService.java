package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(RoomAssignmentRecord record);

    List<RoomAssignmentRecord> getAssignments();

    List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId);

    RoomAssignmentRecord getAssignmentById(Long id);

    void deleteAssignment(Long id);
}
