package com.example.demo.repository;

import com.example.demo.model.RoomAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignment, Long> {
}
