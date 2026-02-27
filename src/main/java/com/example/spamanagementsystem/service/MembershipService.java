package com.example.spamanagementsystem.service;

import com.example.spamanagementsystem.entity.Membership;
import com.example.spamanagementsystem.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }

    public List<Membership> findAll() {
        return membershipRepository.findAll();
    }
}
