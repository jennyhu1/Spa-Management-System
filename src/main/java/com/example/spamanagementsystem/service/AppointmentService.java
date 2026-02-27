package com.example.spamanagementsystem.service;

import com.example.spamanagementsystem.dto.AppointmentDTO;
import com.example.spamanagementsystem.entity.Appointment;

import com.example.spamanagementsystem.entity.ServiceType;
import com.example.spamanagementsystem.repository.AppointmentRepository;
import com.example.spamanagementsystem.repository.CustomerRepository;
import com.example.spamanagementsystem.repository.MassageTherapistRepository;
import com.example.spamanagementsystem.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MassageTherapistRepository massageTherapistRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public Appointment addAppointment(AppointmentDTO appointmentDTO) {
        // TO DO: check massage therapist's availability
        Appointment appointment = new Appointment();
        appointment.setCustomer(customerRepository.findById(appointmentDTO.getCustomerId()).get());
        appointment.setFromTime(appointmentDTO.getFromTime());

        ServiceType serviceType = serviceTypeRepository.findById(appointmentDTO.getServiceTypeId()).get();
        appointment.setToTime(addDuration(appointmentDTO.getFromTime(),serviceType.getDuration()));
        appointment.setServiceType(serviceType);

        appointment.setMassageTherapist(massageTherapistRepository.getById(appointmentDTO.getMassageTherapistId()));
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAllAppointmentsSortedByStartTime() {
        getAllAppointments();
        return null;
    }
    private Date addDuration(Date date, int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
}
