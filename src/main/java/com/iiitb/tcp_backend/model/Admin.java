package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_gender")
    private String adminGender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "admin_dob")
    private Date adminDob;


    @Column(name = "admin_phone_number")
    private String adminPhoneNumber;

    public Admin() {
    }

    public Admin(String adminName, String adminGender, Date adminDob, String adminPhoneNumber) {
        this.adminName = adminName;
        this.adminGender = adminGender;
        this.adminDob = adminDob;
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender;
    }

    public Date getAdminDob() {
        return adminDob;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public void setAdminDob(String adminDob) {
        this.adminDob = Date.valueOf(adminDob);
    }
}
