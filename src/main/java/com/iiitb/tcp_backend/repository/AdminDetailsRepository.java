package com.iiitb.tcp_backend.repository;


import com.iiitb.tcp_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminDetailsRepository extends JpaRepository<Admin, String> {

    @Query(value = "SELECT * FROM admin WHERE admin_id = :id", nativeQuery = true)
    Admin findByAdminId(@Param("id") String id);

    @Query(value = "SELECT * FROM admin", nativeQuery = true)
    List<Admin> getAdmins();
}
