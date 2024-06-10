package com.example.servicequanly.repository;

import com.example.servicequanly.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    List<Journey> findAllByDepartureDateGreaterThanEqual(LocalDate departureDate);
}
