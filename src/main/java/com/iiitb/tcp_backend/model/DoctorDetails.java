package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "doctor_details")
public class DoctorDetails {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    @Column(name = "doctor_name")
    private String doctorName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "doctor_dob")
    private Date doctorDob;

    @Column(name = "doctor_gender")
    private String doctorGender;
    
	@Column(name = "department_name")
    private String departmentName;

    @Column(name = "doctor_qualification")
    private String doctorQualification;

    @Column(name = "doctor_clinic_address")
    private String doctorClinicAddress;

    @Column(name = "doctor_phone_number")
    private String doctorPhoneNumber;

    @Column(name = "doctor_availability")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean doctorAvailability;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
    @Column(name="doctor_start_date")
    private Date doctorStartDate;

    public DoctorDetails(String doctorName, String doctorGender, Date doctorDob, String departmentName, String doctorQualification, String doctorClinicAddress, String doctorPhoneNumber, boolean doctorAvailability, Date doctorStartDate) {
        this.doctorName = doctorName;
        this.doctorDob = doctorDob;
        this.doctorGender = doctorGender;
        this.departmentName = departmentName;
        this.doctorQualification = doctorQualification;
        this.doctorClinicAddress = doctorClinicAddress;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorAvailability = doctorAvailability;
        this.doctorStartDate = doctorStartDate;
    }

    public DoctorDetails() {

    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDoctorDob() {
        return doctorDob;
    }

    public String getDoctorGender() {
  		return doctorGender;
  	}

  	public void setDoctorGender(String doctorGender) {
  		this.doctorGender = doctorGender;
  	}

    
    @Override
	public String toString() {
		return "DoctorDetails [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorDob=" + doctorDob
				+ ", doctorGender=" + doctorGender + ", departmentName=" + departmentName + ", doctorQualification="
				+ doctorQualification + ", doctorClinicAddress=" + doctorClinicAddress + ", doctorPhoneNumber="
				+ doctorPhoneNumber + ", doctorAvailability=" + doctorAvailability + ", doctorStartDate="
				+ doctorStartDate + "]";
	}

	public void setDoctorDob(String doctorDob) {
        this.doctorDob = Date.valueOf(doctorDob);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorQualification() {
        return doctorQualification;
    }
    
    public Date getDoctorStartDate() {
    	return doctorStartDate;
    }

    public void setDoctorStartDate(String doctorStartDate) {
    	this.doctorStartDate = Date.valueOf(doctorStartDate);
    }
    
    public void setDoctorQualification(String doctorQualification) {
        this.doctorQualification = doctorQualification;
    }

    public String getDoctorClinicAddress() {
        return doctorClinicAddress;
    }
    
    

    public void setDoctorClinicAddress(String doctorClinicAddress) {
        this.doctorClinicAddress = doctorClinicAddress;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public boolean isDoctorAvailability() {
        return doctorAvailability;
    }

    public void setDoctorAvailability(boolean doctorAvailability) {
        this.doctorAvailability = doctorAvailability;
    }
}
