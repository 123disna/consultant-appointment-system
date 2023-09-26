package com.system.appointment2.service;
import com.system.appointment2.controller.JobSeekerController;
import com.system.appointment2.dto.AppointmentRequestDTO;
import com.system.appointment2.dto.ConsultantAppointmentCount;
import com.system.appointment2.model.Appointment;
import com.system.appointment2.model.Consultant;
import com.system.appointment2.model.JobSeeker;
import com.system.appointment2.repo.AppointmentRepo;
import com.system.appointment2.repo.ConsultantRepo;
import com.system.appointment2.repo.JobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    @Autowired
    private ConsultantRepo consultantRepo;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JobSeekerController jobSeekerController;


    public void saveAppointment(AppointmentRequestDTO appointment) {

        if(customUserDetailsService.getSeekerId()==0) {
            Appointment appointment1 = new Appointment(
                    appointment.getAppointmentsTime(),
                    consultantRepo.getById(appointment.getConsultant()),
                    jobSeekerRepo.getById(jobSeekerController.getRegSeekerId())

            );
            appointmentRepo.save(appointment1);
        }else{
            Appointment appointment1 = new Appointment(
                    appointment.getAppointmentsTime(),
                    consultantRepo.getById(appointment.getConsultant()),
                    jobSeekerRepo.getById(customUserDetailsService.getSeekerId())

            );
            appointmentRepo.save(appointment1);
        }
    }

    public List<Appointment> allAppointments() {
        List<Appointment> appointments=appointmentRepo.findAll();
        return appointments;
    }

    public void deleteAppointment(int id) {
        appointmentRepo.deleteById(id);
    }

    public List<Appointment> appointmentListBySeeker() {
        JobSeeker jobSeeker = jobSeekerRepo.findById(customUserDetailsService.getSeekerId()).orElse(null);

        if(customUserDetailsService.getSeekerId()==0)
        {
            return Collections.emptyList();
        }else{
            return appointmentRepo.findByJobSeeker(jobSeeker);
        }
    }

    public List<ConsultantAppointmentCount> getCountsByConsultant() {
        List<Object[]> results = appointmentRepo.countAppointmentsByConsultantId();
        List<ConsultantAppointmentCount> appointmentCounts = new ArrayList<>();

        for (Object[] result : results) {
            int consultantId = (int) result[0];
            long appointmentCount = (long) result[1];
            Consultant consultant=consultantRepo.findById(consultantId).get();
            String consultant_name=consultant.getName();
            ConsultantAppointmentCount count = new ConsultantAppointmentCount(consultantId, appointmentCount,consultant_name);
            appointmentCounts.add(count);
        }
        return appointmentCounts;
    }
}
