package com.system.appointment2.controller;
import com.system.appointment2.dto.AppointmentRequestDTO;
import com.system.appointment2.dto.ConsultantAppointmentCount;
import com.system.appointment2.model.Appointment;
import com.system.appointment2.model.Consultant;
import com.system.appointment2.service.AppointmentService;
import com.system.appointment2.service.ConsultantService;
import com.system.appointment2.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ConsultantService consultantService;


    @PostMapping("/save-appointment")
    public String saveAppointment(@ModelAttribute("appointmentRequestDTO") AppointmentRequestDTO appointmentRequestDTO) {
      appointmentService.saveAppointment(appointmentRequestDTO);

        Consultant consultant = consultantService.findById(appointmentRequestDTO.getConsultant());
        if (consultant != null) {
            consultant.removeAvailability(appointmentRequestDTO.getAppointmentsTime());
            consultantService.save(consultant);
        }
      return "redirect:/all-consultant";
    }

    @GetMapping("/list-appointment")
    public String getAllAppointments(Model model)
    {
        List<Appointment> appointment=appointmentService.allAppointments();
        model.addAttribute("appointment",appointment);
        return "all-appointment";
    }

    @GetMapping("/delete-appointment/{id}")
    public String deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        return "redirect:/list-appointment";
    }

   @GetMapping("/appointment-history-by-seeker")
    public String appointmentHistory(Model model)
    {
        List<Appointment> appointment=appointmentService.appointmentListBySeeker();
        model.addAttribute("appointment",appointment);
        return "app-history";
    }

    @GetMapping("/appointments-by-consultant")
    public String getAppointments(Model model) {
        List<ConsultantAppointmentCount> appointmentCounts = appointmentService.getCountsByConsultant();
        model.addAttribute("appointmentCounts", appointmentCounts);
        return "appointments_by_consultant";
    }
}
