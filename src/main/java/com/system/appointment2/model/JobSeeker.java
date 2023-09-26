package com.system.appointment2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "jobSeekers")
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jobSeeker_id;

    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "jobSeeker",fetch = FetchType.EAGER)
    private Set<Appointment> appointments;


    public JobSeeker(int jobSeeker_id, String name, String email, String password, Set<Appointment> appointments) {
        this.jobSeeker_id = jobSeeker_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.appointments = appointments;
    }

    public JobSeeker(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public JobSeeker() {
    }

    public int getJobSeeker_id() {
        return jobSeeker_id;
    }

    public void setJobSeeker_id(int jobSeeker_id) {
        this.jobSeeker_id = jobSeeker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "jobSeeker_id=" + jobSeeker_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
