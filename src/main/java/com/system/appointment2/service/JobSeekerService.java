package com.system.appointment2.service;

import com.system.appointment2.model.JobSeeker;
import com.system.appointment2.repo.JobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    public JobSeeker getJobSeekerById(Integer jobSeeker_id) {
        JobSeeker jobSeeker=jobSeekerRepo.findById(jobSeeker_id).get();
        return jobSeeker;
    }
}
