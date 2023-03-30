package com.iiitb.tcp_backend.repository;

import com.iiitb.tcp_backend.model.AdminLogin;
import com.iiitb.tcp_backend.model.DoctorLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminLoginRepository extends JpaRepository<AdminLogin, String> {

    @Query(value = "SELECT * FROM admin_login WHERE admin_id = :id", nativeQuery = true)
    AdminLogin findByAdminId(@Param("id") int id);
    @Query(value = "SELECT * FROM admin_login WHERE admin_email_id = :email_id", nativeQuery = true)
    AdminLogin findByAdminEmail(@Param("username") String username);
    @Query(value = "SELECT * FROM admin_login", nativeQuery = true)
    List<AdminLogin> getAdmins();


}
