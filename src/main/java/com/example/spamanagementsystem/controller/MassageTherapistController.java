package com.example.spamanagementsystem.controller;

import com.example.spamanagementsystem.entity.MassageTherapist;
import com.example.spamanagementsystem.service.MassageTherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("massage-therapist")
public class MassageTherapistController {
    @Autowired
    MassageTherapistService massageTherapistService;


    @GetMapping
    public List<MassageTherapist> getAllMassageTherapist() {
        return massageTherapistService.getAll();
    }

    @GetMapping("{id}")
    public MassageTherapist getById(@PathVariable Long id) {
        return massageTherapistService.getById(id);
    }

    @PostMapping
    public MassageTherapist create(@RequestBody MassageTherapist massageTherapist) {
        return massageTherapistService.create(massageTherapist);
    }

    //create an appointment
}
