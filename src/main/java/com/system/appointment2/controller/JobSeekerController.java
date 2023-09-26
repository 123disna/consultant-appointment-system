package com.system.appointment2.controller;

import com.system.appointment2.dto.RegisterRequestDTO;
import com.system.appointment2.model.JobSeeker;
import com.system.appointment2.repo.JobSeekerRepo;
import com.system.appointment2.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class JobSeekerController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    @Autowired
    private JobSeekerService jobSeekerService;

    int seekerId;


    @PostMapping("/new-seeker")
    public String saveSeeker(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO)
    {
        JobSeeker jobSeeker=new JobSeeker(
                registerRequestDTO.getName(),
                registerRequestDTO.getEmail(),
                passwordEncoder.encode(registerRequestDTO.getPassword())
        );
        jobSeekerRepo.save(jobSeeker);
        seekerId=jobSeeker.getJobSeeker_id();
        return "redirect:/all-consultant";

    }

    @GetMapping("/new-seeker")
    public String showRegForm(Model model) {
        model.addAttribute("registerRequestDTO", new RegisterRequestDTO());
        return "register-form";
    }

    public int getRegSeekerId()
    {
        return seekerId;
    }
}
