package com.system.appointment2.repo;

import com.system.appointment2.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
@Transactional
public interface JobSeekerRepo extends JpaRepository<JobSeeker,Integer> {
    JobSeeker findByEmail(String email);
}
