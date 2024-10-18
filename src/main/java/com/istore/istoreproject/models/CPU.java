package com.istore.istoreproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cpu_id;

    @Column(name = "cpu_model")
    private String model;

    private String speed;

    private int corsNumber;
    
}
