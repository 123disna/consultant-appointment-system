package com.system.appointment2.controller;

import com.system.appointment2.model.Admin;
import com.system.appointment2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/save/admin")
    public String saveAdmin(@ModelAttribute("admin")Admin admin)
    {
        adminService.saveAdmin(admin);
        return "redirect:/";
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        try {
            if (adminService.isAdminCredentialsValid(username, password)) {
                return "redirect:/consultant-manage";
            } else {
                redirectAttributes.addFlashAttribute("error", true);
                System.out.println("invalid username or password");
                return "admin-login";
            }
        }catch (NoSuchElementException e) {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/admin/login")
    public String loginForm()
    {
        return "admin-login";
    }

    @PostConstruct
    public void initAdmin()
    {
        adminService.initAdmin();
    }
}
