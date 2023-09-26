package com.system.appointment2.dto;

import java.time.LocalDateTime;

public class AppointmentRequestDTO {
    private LocalDateTime appointmentsTime;
    private int consultant;

    public AppointmentRequestDTO(LocalDateTime appointmentsTime, int consultant) {
        this.appointmentsTime = appointmentsTime;
        this.consultant = consultant;
    }

    public LocalDateTime getAppointmentsTime() {
        return appointmentsTime;
    }

    public void setAppointmentsTime(LocalDateTime appointmentsTime) {
        this.appointmentsTime = appointmentsTime;
    }

    public int getConsultant() {
        return consultant;
    }

    public void setConsultant(int consultant) {
        this.consultant = consultant;
    }

    @Override
    public String toString() {
        return "AppointmentRequestDTO{" +
                "appointmentsTime=" + appointmentsTime +
                ", consultant=" + consultant +
                '}';
    }
}
