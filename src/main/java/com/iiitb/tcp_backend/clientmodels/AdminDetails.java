package com.iiitb.tcp_backend.clientmodels;

import java.sql.Date;

public class AdminDetails {

    private int admin_id;
    private String name;
    private Date dob;
    private String gender;
    private String email_id;
    private String password;
    private String phone_number;

    public AdminDetails( int id, String name, Date dob, String gender, String email_id, String password, String phone_number) {
        this.admin_id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email_id = email_id;
        this.password = password;
        this.phone_number = phone_number;
    }


    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminDetails{" +
                "admin_id=" + admin_id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", email_id='" + email_id + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    public Date getDob() {
        return dob;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
