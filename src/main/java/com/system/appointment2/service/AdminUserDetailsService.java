package com.system.appointment2.service;

import com.system.appointment2.model.Admin;
import com.system.appointment2.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("adminUserDetailsService")
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminUserDetailsService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findById(username).orElse(null);

        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found with username: " + username);
        }

        // You can customize the authorities as needed; here, we grant the "ADMIN" role.
        return org.springframework.security.core.userdetails.User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .roles("ADMIN")
                .build();
    }
}
