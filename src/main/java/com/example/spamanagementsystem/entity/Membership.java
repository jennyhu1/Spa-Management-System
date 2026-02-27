package com.example.spamanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer discountLevel;

    @OneToMany(mappedBy = "membership")
    private Set<Customer> customers = new HashSet<>();
}
