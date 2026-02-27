package com.example.spamanagementsystem.service;


import com.example.spamanagementsystem.dto.DepositDTO;
import com.example.spamanagementsystem.entity.Customer;
import com.example.spamanagementsystem.entity.Membership;
import com.example.spamanagementsystem.repository.CustomerRepository;
import com.example.spamanagementsystem.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MembershipRepository membershipRepository;

    public Customer saveCustomer(Customer customer) {
        customer.setMembership(belongsToWhichMembership(customer.getBalance()));
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.getReferenceById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer deposit(DepositDTO depositDTO) {
        Long customerId = depositDTO.getCustomerId();
        Double amount = depositDTO.getAmount();
        Customer customer = customerRepository.getReferenceById(customerId);
        customer.setBalance(customer.getBalance() + amount);

        Membership currentMemberShipAssociateWithCustomer = customer.getMembership();

        Membership canGetMembershipWithThisAmountDeposited = belongsToWhichMembership(amount);
        if (currentMemberShipAssociateWithCustomer == null) {
            customer.setMembership(canGetMembershipWithThisAmountDeposited);
        } else if (customer.getMembership().getDiscountLevel() > canGetMembershipWithThisAmountDeposited.getDiscountLevel()) {
            customer.setMembership(canGetMembershipWithThisAmountDeposited);
        }
        return customerRepository.save(customer);
    }

    private Membership belongsToWhichMembership(Double amount) {
        List<Membership> all = membershipRepository.findAll();
        Map<String, Membership> membershipMap = new HashMap<>();
        for (Membership membership : all) {
            membershipMap.put(membership.getName(), membership);
        }
        if(amount < 1000) return null;
        else if(amount < 2000) return membershipMap.get("Basic Membership");
        else if(amount < 3000) return membershipMap.get("Silver Membership");
        else if(amount < 4000) return membershipMap.get("Gold Membership");
        else if(amount < 5000) return membershipMap.get("Platinum Membership");
        else return membershipMap.get("Diamond Membership");
    }
}
