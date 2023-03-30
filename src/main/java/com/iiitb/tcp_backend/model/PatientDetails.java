package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "patient_details")
public class PatientDetails {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_email_id")
    private String patientEmailId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "patient_dob")
    private Date patientDob;


    @Column(name = "gender")
    private String gender;

    @Column(name = "patient_phone_number")
    private String patientPhoneNumber;

    @Column(name = "patient_location")
    private String patientLocation;

    public PatientDetails() {
    }

    public PatientDetails(String patientName, String patientEmailId, String patientDob, String gender, String patientPhoneNumber, String patientLocation) {
        this.patientName = patientName;
        this.patientEmailId = patientEmailId;
        this.patientDob = Date.valueOf(patientDob);
        this.gender = gender;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientLocation = patientLocation;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmailId() {
        return patientEmailId;
    }

    public void setPatientEmailId(String patientEmailId) {
        this.patientEmailId = patientEmailId;
    }

    public Date getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(String patientDob) {
        this.patientDob = Date.valueOf(patientDob);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientLocation() {
        return patientLocation;
    }

    public void setPatientLocation(String patientLocation) {
        this.patientLocation = patientLocation;
    }
}
