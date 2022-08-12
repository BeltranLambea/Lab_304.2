package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.model.Aircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {

    @Autowired
    private AircraftRepository aircraftRepository;

    Aircraft a1;
    Aircraft a2;
    Aircraft a3;
    Aircraft a4;
    List<Aircraft> aircrafts;

    @BeforeEach
    void setUp() {
        aircraftRepository.deleteAll();
        aircrafts = List.of(
                a1 = new Aircraft("Boeing777", 400),
                a2 = new Aircraft("Airbus777", 300),
                a3 = new Aircraft("Boeing888", 200)
        );
        aircraftRepository.saveAll(aircrafts);
    }

    @Test
    void test_save_3_ok() {
        assertEquals(3, aircraftRepository.count());
    }

    @Test
    void findByAircraftContaining_Air() {
        int found = aircraftRepository.findByNameContaining("Air").size();
        assertEquals(1, found);
    }

    @Test
    void findByAircraftContaining_Boeing() {
        int found = aircraftRepository.findByNameContaining("Boeing").size();
        assertEquals(2, found);
    }
}