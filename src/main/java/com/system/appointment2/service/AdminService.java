package com.system.appointment2.service;

import com.system.appointment2.model.Admin;
import com.system.appointment2.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public void initAdmin()
    {
        if(!adminRepo.existsById("sew@gmail.com"))
        {
            Admin admin=new Admin();
            admin.setUsername("sew@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            adminRepo.save(admin);
        }
    }

    public boolean isAdminCredentialsValid(String username, String password) {
        Admin admin=adminRepo.findById(username).get();
        if(admin!=null && passwordEncoder.matches(password, admin.getPassword()))
        {
            return true;
        }
        else
            return false;
    }
}
