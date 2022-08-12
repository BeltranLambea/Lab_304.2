package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.model.Aircraft;
import com.ironhack.lab_304.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    Flight f1;
    Flight f2;
    Flight f3;
    Flight f4;

    List<Flight> flights;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        AircraftRepositoryTest aircraftTests = new AircraftRepositoryTest();
        flights = List.of(
                f1 = new Flight("AAA1", 600,"Boeing777"),
                f2 = new Flight("BBB2", 550,"Boeing777"),
                f3 = new Flight("CCC3",100,"Boeing888")
        );
        flightRepository.saveAll(flights);
    }

    @Test
    void test_save_3_ok() {
        assertEquals(3, flightRepository.count());
    }

    @Test
    void findByNumber() {
        int found = flightRepository.findByNumber("AAA1").size();
        assertEquals(1, found);
    }

    @Test
    void findByMileageGreaterThan() {
        int found = flightRepository.findByMileageGreaterThan(500).size();
        assertEquals(2, found);
    }
}