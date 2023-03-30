package com.iiitb.tcp_backend.clientmodels;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Doctor {



	private int doctor_id;

    private String name;
    private Date dob;
    private String gender;
    private String email_id;
    private Date doctor_start_date;
    private String qualification;
	private String department_name;
    private String phone_number;
    private String clinic_address;
    private String password;
    

	public Doctor() {
    }

    public Doctor(int id, String name, Date dob, String gender, String email_id, Date doctor_start_date,
    		String qualification, String department_name, String phone_number, String clinic_address, String password) {
		this.doctor_id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email_id = email_id;
        this.doctor_start_date = doctor_start_date;
        this.qualification = qualification;
        this.department_name = department_name;
        this.phone_number = phone_number;
        this.clinic_address = clinic_address;
        this.password = password;
    }
    
    

    @Override
	public String toString() {
		return "Doctor [name=" + name + ", dob=" + dob + ", gender=" + gender + ", email_id=" + email_id
				+ ", doctor_start_date=" + doctor_start_date + ", qualification=" + qualification + ", department_name="
				+ department_name + ", phone_number=" + phone_number + ", clinic_address=" + clinic_address
				+ ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Date getDoctor_start_date() {
		return doctor_start_date;
	}

	public void setDoctor_start_date(Date doctor_start_date) {
		this.doctor_start_date = doctor_start_date;
	}

	public String getQualification() {
		return qualification;
	}
	
  public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getClinic_address() {
		return clinic_address;
	}

	public void setClinic_address(String clinic_address) {
		this.clinic_address = clinic_address;
	}
    
}
