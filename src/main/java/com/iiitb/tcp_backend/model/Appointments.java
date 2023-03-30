package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "prescription_id")
    private int prescriptionId;

    @Column(name = "follow_up")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean followUp;

    @Column(name = "follow_up_date")
    private Date followUpDate;

    public Appointments() {
    }

    public Appointments( int doctorId, int patientId, String appointmentDate, int prescriptionId, boolean followUp, String followUpDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = Date.valueOf(appointmentDate);
        this.prescriptionId = prescriptionId;
        this.followUp = followUp;
        this.followUpDate = Date.valueOf(followUpDate);
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = Date.valueOf(appointmentDate);
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = Date.valueOf(followUpDate);
    }
}
