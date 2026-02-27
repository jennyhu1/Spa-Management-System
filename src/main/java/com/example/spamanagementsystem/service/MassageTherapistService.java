package com.example.spamanagementsystem.service;

import com.example.spamanagementsystem.entity.MassageTherapist;
import com.example.spamanagementsystem.repository.CustomerRepository;
import com.example.spamanagementsystem.repository.MassageTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MassageTherapistService {
    @Autowired
    MassageTherapistRepository massageTherapistRepository;

    @Autowired
    CustomerRepository customerRepository;


    public List<MassageTherapist> getAll() {
        return massageTherapistRepository.findAll();
    }

    public MassageTherapist getById(Long id) {
        return massageTherapistRepository.findById(id).get();
    }

    public MassageTherapist create(MassageTherapist massageTherapist) {
        return massageTherapistRepository.save(massageTherapist);
    }
}
