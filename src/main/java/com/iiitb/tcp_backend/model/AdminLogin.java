package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "admin_login")
public class AdminLogin {
    @Id
    @Column(name = "admin_email_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String adminEmailId ;

    @Column(name = "admin_password")
    private String adminPassword ;

    @Column(name = "admin_id")
    private int adminId;
    
    @Column(name = "is_admin_active")
    private boolean isAdminActive;
    
    public AdminLogin() {

    }

    public AdminLogin(String adminEmailId, String adminPassword, int adminId, boolean isAdminActive) {
        this.adminEmailId = adminEmailId;
        this.adminPassword = adminPassword;
        this.adminId = adminId;
        this.isAdminActive = isAdminActive;
    }

    public String getAdminEmailId() {
        return adminEmailId;
    }

    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
    
    public boolean getIsAdminActive()
    {
    	return isAdminActive;
    }

    public void setIsAdminActive(boolean isAdminActive)
    {
    	this.isAdminActive = isAdminActive;
    }
    
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
