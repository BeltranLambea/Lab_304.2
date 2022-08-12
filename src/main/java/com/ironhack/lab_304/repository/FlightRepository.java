package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository <Flight, String> {
    List<Flight> findByNumber(String number);
    List<Flight> findByMileageGreaterThan(long distance);
}
