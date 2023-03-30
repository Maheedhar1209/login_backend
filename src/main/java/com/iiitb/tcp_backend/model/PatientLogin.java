package com.iiitb.tcp_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
@Entity
@Table(name = "Patient_login")
public class PatientLogin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "otp_value")
  private String otpValue;

public void setPhoneNumber(String phoneNumber2) {
    this.phoneNumber=phoneNumber2;
}
public String getPhoneNumber() {
    return this.phoneNumber;
}
public void setOtpValue(String otp) {
  this.otpValue=otp;
}
public String getOtpValue()
{
    return this.otpValue;
}
  // Constructors, getters, and setters
}
