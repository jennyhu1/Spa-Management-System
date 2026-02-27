package com.example.spamanagementsystem.controller;

import com.example.spamanagementsystem.dto.DepositDTO;
import com.example.spamanagementsystem.dto.CustomerPreferenceDTO;
import com.example.spamanagementsystem.entity.Customer;
import com.example.spamanagementsystem.entity.CustomerPreference;
import com.example.spamanagementsystem.service.CustomerPreferenceService;
import com.example.spamanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("deposit")
    public Customer depositCustomer(@RequestBody DepositDTO depositDTO) {
        return customerService.deposit(depositDTO);
    }

    @PostMapping("preference")
    public CustomerPreference addCustomerPreference(@RequestBody CustomerPreferenceDTO customerPreferenceDTO) {
        return customerPreferenceService.save(customerPreferenceDTO);
    }

    //review :
    // 享受过对应技师的服务才能写review
}
