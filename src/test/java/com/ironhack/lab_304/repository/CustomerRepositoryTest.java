package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.enums.CustomerStatus;
import com.ironhack.lab_304.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    Customer c1;
    Customer c2;
    Customer c3;
    Customer c4;
    List<Customer> customers;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        customers = List.of(
                c1 = new Customer("Luis", CustomerStatus.GOLD, 1000),
                c2 = new Customer("Ana", CustomerStatus.SILVER, 500),
                c3 = new Customer("Juan", CustomerStatus.NONE, 0)
        );
        customerRepository.saveAll(customers);
    }

    @Test
    void test_save_3_ok() {
        assertEquals(3, customerRepository.count());
    }

    @Test
    void test_findByName() {
        c4 = customerRepository.findByName("Luis").get(0);
        assertEquals(c1.getName(), c4.getName());
    }

    @Test
    void test_findByStatus() {
        c4 = customerRepository.findByStatus(CustomerStatus.SILVER).get(0);
        assertEquals(c2.getStatus(), c4.getStatus());
    }
}