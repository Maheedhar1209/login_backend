package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

class PrescriptionId implements Serializable {

    int prescription_id;
    long medicineName;
}

@Entity
@Table(name = "prescriptions")
@IdClass(PrescriptionId.class)
public class Prescriptions implements Serializable {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescription_id;

    @Id
    @Column(name = "medicine_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String medicineName;

    @Column(name = "medicine_power")
    private String medicinePower;

    @Column(name = "medicine_dosage")
    private String medicineDosage;

    @Column(name = "duration")
    private int duration;

    @Column(name = "additional_instructions")
    private String additionalInstructions ;

    @Column(name = "patient_record_id")
    private String doctorName;

    public Prescriptions() {
    }

    public Prescriptions( String medicineName, String medicinePower, String medicineDosage, int duration, String additionalInstructions, String doctorName) {
        this.medicineName = medicineName;
        this.medicinePower = medicinePower;
        this.medicineDosage = medicineDosage;
        this.duration = duration;
        this.additionalInstructions = additionalInstructions;
        this.doctorName = doctorName;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePower() {
        return medicinePower;
    }

    public void setMedicinePower(String medicinePower) {
        this.medicinePower = medicinePower;
    }

    public String getMedicineDosage() {
        return medicineDosage;
    }

    public void setMedicineDosage(String medicineDosage) {
        this.medicineDosage = medicineDosage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
