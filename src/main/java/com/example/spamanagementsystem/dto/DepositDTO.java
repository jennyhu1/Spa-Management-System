package com.example.spamanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {
    private Long customerId;
    private Double amount;
}
