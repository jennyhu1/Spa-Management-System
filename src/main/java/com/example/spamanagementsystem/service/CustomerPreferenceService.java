package com.example.spamanagementsystem.service;

import com.example.spamanagementsystem.dto.CustomerPreferenceDTO;
import com.example.spamanagementsystem.entity.CustomerPreference;
import com.example.spamanagementsystem.repository.CustomerPreferenceRepository;
import com.example.spamanagementsystem.repository.CustomerRepository;
import com.example.spamanagementsystem.repository.MassageTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferenceService {
    @Autowired
    CustomerPreferenceRepository customerPreferenceRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MassageTherapistRepository massageTherapistRepository;

    public CustomerPreference save(CustomerPreferenceDTO customerPreferenceDTO) {
        CustomerPreference customerPreference = new CustomerPreference();
        customerPreference.setCustomer(customerRepository.findById(customerPreferenceDTO.getCustomerId()).orElse(null));
        customerPreference.setMassageTherapist(massageTherapistRepository.findById(customerPreferenceDTO.getMassageTherapistId()).orElse(null));
        return customerPreferenceRepository.save(customerPreference);
    }
}
