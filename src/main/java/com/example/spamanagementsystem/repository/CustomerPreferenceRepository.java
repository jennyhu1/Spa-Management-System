package com.example.spamanagementsystem.repository;

import com.example.spamanagementsystem.entity.CustomerPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreference, Long> {
}
