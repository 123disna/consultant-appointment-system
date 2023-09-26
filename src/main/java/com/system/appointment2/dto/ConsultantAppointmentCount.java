package com.system.appointment2.dto;

public class ConsultantAppointmentCount {
    private int consultantId;
    private long appointmentCount;
    private String consultant_name;

    public ConsultantAppointmentCount(int consultantId, long appointmentCount, String consultant_name) {
        this.consultantId = consultantId;
        this.appointmentCount = appointmentCount;
        this.consultant_name = consultant_name;
    }

    public int getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(int consultantId) {
        this.consultantId = consultantId;
    }

    public long getAppointmentCount() {
        return appointmentCount;
    }

    public void setAppointmentCount(long appointmentCount) {
        this.appointmentCount = appointmentCount;
    }

    public String getConsultant_name() {
        return consultant_name;
    }

    public void setConsultant_name(String consultant_name) {
        this.consultant_name = consultant_name;
    }

    @Override
    public String toString() {
        return "ConsultantAppointmentCount{" +
                "consultantId=" + consultantId +
                ", appointmentCount=" + appointmentCount +
                ", consultant_name='" + consultant_name + '\'' +
                '}';
    }
}
