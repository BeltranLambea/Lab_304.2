package com.ironhack.lab_304.repository;

import com.ironhack.lab_304.enums.CustomerStatus;
import com.ironhack.lab_304.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByStatus(CustomerStatus status);
}
