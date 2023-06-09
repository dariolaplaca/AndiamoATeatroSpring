package com.develhope.JTeathreSpring.repositories;

import com.develhope.JTeathreSpring.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
