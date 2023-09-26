package com.system.appointment2.repo;

import com.system.appointment2.model.Appointment;
import com.system.appointment2.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
    List<Appointment> findByJobSeeker(JobSeeker seekerId);

    @Query("SELECT a.consultant.id, COUNT(a) FROM Appointment a GROUP BY a.consultant.id")
    List<Object[]> countAppointmentsByConsultantId();
}
