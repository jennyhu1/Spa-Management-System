package com.example.spamanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date birthday;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<CustomerPreference> customerPreferences = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
}
