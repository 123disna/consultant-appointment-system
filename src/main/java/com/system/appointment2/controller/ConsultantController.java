package com.system.appointment2.controller;

import com.system.appointment2.model.Appointment;
import com.system.appointment2.model.Consultant;
import com.system.appointment2.service.AppointmentService;
import com.system.appointment2.service.ConsultantService;
import com.system.appointment2.util.LocalDateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsultantController {
    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/add-consultant")
    public String addConsultant(@ModelAttribute("consultant")Consultant consultant)
    {
        consultantService.addConsultant(consultant);
        return"redirect:/consultant-manage";
    }

    @GetMapping("/add-consultant")
    public String showConsultantForm(Model model)
    {
        model.addAttribute("consultant",new Consultant());
        return "consultant-form";
    }

    @GetMapping("/all-consultant")
    public String AllConsultant(Model model)
    {
        List<Consultant> consultant=consultantService.allConsultants();
        model.addAttribute("consultant",consultant);
        return "all_consultants";
    }

    @GetMapping("/all-consultant/def")
    public String AllConsultantDefault(Model model)
    {
        List<Consultant> consultant=consultantService.allConsultants();
        model.addAttribute("consultant",consultant);
        return "all_consultants_def";
    }

    @GetMapping("/consultant-profile/{id}")
    public String consultantProfile(@PathVariable(value = "id")int id,Model model)
    {
           model.addAttribute("consultant",consultantService.getConsultantById(id));
           return "user-profile";
    }

    @GetMapping("/consultant-profile-def/{id}")
    public String consultantProfileDefault(@PathVariable(value = "id")int id,Model model)
    {
        model.addAttribute("consultant",consultantService.getConsultantById(id));
        return "def-user-profile";
    }
    @GetMapping("/consultant-manage")
    public String consultantManage(Model model)
    {
        List<Consultant> consultant=consultantService.allConsultants();
        model.addAttribute("consultant",consultant);
        return "manage-consultant";
    }

    @GetMapping("/consultant/edit/{id}")
    public String editConsultant(@PathVariable(value = "id") int id,Model model){
        model.addAttribute("consultant",consultantService.getConsultantById(id));
        return "edit_consultant";
    }

    @PostMapping("/consultant/{id}")
    public String updateConsultant(@PathVariable int id,
                                @ModelAttribute("consultant")Consultant consultant,
                                Model model){
        Consultant existConsultant= (Consultant) consultantService.getConsultantById(id);
        existConsultant.setName(consultant.getName());
        existConsultant.setSpecializationCountry(consultant.getSpecializationCountry());
        existConsultant.setAvailability(consultant.getAvailability());

        consultantService.updateConsultant(existConsultant);
        return "redirect:/consultant-manage";
    }

    @GetMapping("/delete-consultant/{id}")
    public String deleteConsultant(@PathVariable int id){
        consultantService.deleteConsultant(id);
        return "redirect:/consultant-manage";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new LocalDateTimeFormatter());
    }
}
