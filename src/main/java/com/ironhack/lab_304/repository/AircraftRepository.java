package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftRepository extends JpaRepository <Aircraft, String> {
    List<Aircraft> findByNameContaining(String name);
}
