package com.example.spamanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fromTime;
    private Date toTime;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "massage_therapist_id")
    @JsonBackReference
    private MassageTherapist massageTherapist;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    @JsonBackReference
    private ServiceType serviceType;

}