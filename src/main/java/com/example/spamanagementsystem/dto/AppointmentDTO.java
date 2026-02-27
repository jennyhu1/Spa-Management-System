package com.example.spamanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    AppointmentDTO {
    private Date fromTime;
    private Long customerId;
    private Long massageTherapistId;
    private Long serviceTypeId;
}
