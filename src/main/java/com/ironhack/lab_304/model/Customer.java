package com.ironhack.lab_304.model;

import com.ironhack.lab_304.enums.CustomerStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
    private long mileage;

    public Customer(String name, CustomerStatus status, long mileage) {
        this.name = name;
        this.status = status;
        this.mileage = mileage;
    }
}
