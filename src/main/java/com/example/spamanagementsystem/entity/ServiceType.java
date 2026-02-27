package com.example.spamanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer duration; // Duration in minutes
    private Integer price;

    @OneToMany(mappedBy = "serviceType")
    private Set<Order> orders = new HashSet<>();
}
