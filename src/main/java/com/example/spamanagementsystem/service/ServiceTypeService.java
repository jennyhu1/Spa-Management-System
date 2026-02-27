package com.example.spamanagementsystem.service;

import com.example.spamanagementsystem.entity.ServiceType;
import com.example.spamanagementsystem.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeRepository.findAll();
    }
    public ServiceType createServiceType(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }
}
