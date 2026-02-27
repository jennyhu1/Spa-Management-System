package com.example.spamanagementsystem.controller;

import com.example.spamanagementsystem.entity.Membership;
import com.example.spamanagementsystem.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("membership")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.findAll();
    }

    @PostMapping
    public Membership createMembership(@RequestBody Membership membership) {
        return membershipService.save(membership);
    }
}
