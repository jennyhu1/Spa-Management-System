package com.example.spamanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPreferenceDTO {
    private Long customerId;
    private Long massageTherapistId;
}
