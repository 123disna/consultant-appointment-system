package com.system.appointment2.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "consultants")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int consultant_id;
    private String name;
    private String specializationCountry;

    @Type(type = "json")
    @Column(name = "availability",columnDefinition = "json",length = 20)
    private List<LocalDateTime> availability;

    @OneToMany(mappedBy = "consultant",fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

    public Consultant() {
    }

    public Consultant(int id, String name, String specializationCountry, List<LocalDateTime> availability, Set<Appointment> appointments) {
        this.consultant_id = id;
        this.name = name;
        this.specializationCountry = specializationCountry;
        this.availability = availability;
        this.appointments = appointments;
    }

    public int getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(int consultant_id) {
        this.consultant_id = consultant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecializationCountry() {
        return specializationCountry;
    }

    public void setSpecializationCountry(String specializationCountry) {
        this.specializationCountry = specializationCountry;
    }

    public List<LocalDateTime> getAvailability() {
        return availability;
    }

    public void setAvailability(List<LocalDateTime> availability) {
        this.availability = availability;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + consultant_id +
                ", name='" + name + '\'' +
                ", specializationCountry='" + specializationCountry + '\'' +
                ", availability=" + availability +
                ", appointments=" + appointments +
                '}';
    }

    public void removeAvailability(LocalDateTime appointmentTime) {
        availability.remove(appointmentTime);
    }
}
