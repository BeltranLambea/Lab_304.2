package com.ironhack.lab_304.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aircraft {
    @Id
    private String name;
    private Integer seats;

    public Aircraft(String name, Integer seats) {
        this.name = name;
        this.seats = seats;
    }
}
