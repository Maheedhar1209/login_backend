package com.iiitb.tcp_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.iiitb.tcp_backend.model.PatientLogin;
public interface PatientLoginRepository extends JpaRepository<PatientLogin, String> {

  PatientLogin findByPhoneNumber(String phoneNumber);

}

