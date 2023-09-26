package com.system.appointment2.service;

import com.system.appointment2.model.JobSeeker;
import com.system.appointment2.repo.JobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional; // Import Optional from java.util

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JobSeekerRepo jobSeekerRepo;

    int seekerId;

    @Autowired
    public CustomUserDetailsService(JobSeekerRepo jobSeekerRepo) {
        this.jobSeekerRepo = jobSeekerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<JobSeeker> optionalJobSeeker = Optional.ofNullable(jobSeekerRepo.findByEmail(username));
        seekerId=jobSeekerRepo.findByEmail(username).getJobSeeker_id();

        JobSeeker jobSeeker = optionalJobSeeker.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username)
        );


        // Return a UserDetails object (you can use a custom UserDetails implementation)
        return org.springframework.security.core.userdetails.User.builder()
                .username(jobSeeker.getEmail())
                .password(jobSeeker.getPassword())
                .roles("USER") // Assign roles or authorities as needed
                .build();
    }

    public int getSeekerId()
    {
        return seekerId;
    }
}
