package com.example.spamanagementsystem.controller;

import com.example.spamanagementsystem.entity.ServiceType;
import com.example.spamanagementsystem.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-type")
public class ServiceTypeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping
    public List<ServiceType> getAllServiceType(){
        return serviceTypeService.getAllServiceTypes();
    }

    @PostMapping
    public ServiceType addServiceType(@RequestBody ServiceType serviceType){
        return serviceTypeService.createServiceType(serviceType);
    }
}
