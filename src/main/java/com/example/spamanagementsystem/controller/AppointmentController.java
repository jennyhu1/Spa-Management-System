package com.example.spamanagementsystem.controller;

import com.example.spamanagementsystem.dto.AppointmentDTO;
import com.example.spamanagementsystem.entity.Appointment;
import com.example.spamanagementsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.addAppointment(appointmentDTO);
    }
}
