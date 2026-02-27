package com.example.spamanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table
public class MassageTherapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date birthday;
    private String no;
    private Float rating = 0.0f;

    @OneToMany(mappedBy = "massageTherapist")
    private Set<Review> reviews = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "massageTherapist")
    private Set<CustomerPreference> customerPreferences = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "massageTherapist")
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "massageTherapist")
    private Set<Order> orders = new HashSet<>();
}
