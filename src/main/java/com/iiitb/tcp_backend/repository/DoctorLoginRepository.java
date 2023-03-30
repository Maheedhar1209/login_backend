package com.iiitb.tcp_backend.repository;

import com.iiitb.tcp_backend.model.DoctorDetails;
import com.iiitb.tcp_backend.model.DoctorLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorLoginRepository extends JpaRepository<DoctorLogin, String> {

    @Query(value = "SELECT * FROM doctor_login WHERE doctor_id = :id", nativeQuery = true)
    DoctorLogin findByDoctorId(@Param("id") int id);
    @Query(value = "SELECT * FROM doctor_login WHERE doctor_email_id = :email_id", nativeQuery = true)
    DoctorLogin findByDoctorEmail(@Param("username") String username);
    @Query(value = "SELECT * FROM doctor_login", nativeQuery = true)
    List<DoctorLogin> getDoctors();

}
