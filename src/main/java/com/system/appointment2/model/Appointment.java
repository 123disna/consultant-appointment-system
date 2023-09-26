package com.system.appointment2.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime appointmentsTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;

    public Appointment() {
    }

    public Appointment(int id, LocalDateTime appointmentsTime, Consultant consultant, JobSeeker jobSeeker) {
        this.id = id;
        this.appointmentsTime = appointmentsTime;
        this.consultant = consultant;
        this.jobSeeker = jobSeeker;
    }

    public Appointment(LocalDateTime appointmentsTime, Consultant consultant, JobSeeker jobSeeker) {
        this.appointmentsTime = appointmentsTime;
        this.consultant = consultant;
        this.jobSeeker = jobSeeker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentsTime() {
        return appointmentsTime;
    }

    public void setAppointmentsTime(LocalDateTime appointmentsTime) {
        this.appointmentsTime = appointmentsTime;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentsTime=" + appointmentsTime +
                ", consultant=" + consultant +
                ", jobSeeker=" + jobSeeker +
                '}';
    }
}
