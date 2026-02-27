package com.example.spamanagementsystem.repository;

import com.example.spamanagementsystem.entity.MassageTherapist;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassageTherapistRepository extends JpaRepository<MassageTherapist, Long> {
}
