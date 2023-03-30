package com.iiitb.tcp_backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.iiitb.tcp_backend.model.PatientLogin;
import com.iiitb.tcp_backend.repository.PatientLoginRepository;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class PatientLoginService {

  @Autowired
  private PatientLoginRepository userRepository;

  @Value("${twilio.account.sid}")
  private String twilioAccountSid;

  @Value("${twilio.auth.token}")
  private String twilioAuthToken;

  @Value("${twilio.phone.number}")
  private String twilioPhoneNumber;

  private TwilioRestClient twilioRestClient;

  @PostConstruct
  public void init() {
    twilioRestClient = new TwilioRestClient.Builder(twilioAccountSid, twilioAuthToken).build();
  }

  public int generateOTP(String phoneNumber) {
    // Generate a random 6-digit OTP
    String otp = String.format("%06d", new Random().nextInt(999999));

    // Store the OTP in the database for verification later
    PatientLogin user = userRepository.findByPhoneNumber(phoneNumber);
    if (user == null) {
      user = new PatientLogin();
      user.setPhoneNumber(phoneNumber);
    }
    user.setOtpValue(otp);
    userRepository.save(user);

    // Send the OTP to the user's phone via SMS
     final String ACCOUNT_SID = "your_account_sid_here";
     final String AUTH_TOKEN = "your_auth_token_here";
      final String FROM_NUMBER = "your_twilio_phone_number_here";
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(FROM_NUMBER),
                "Your OTP is: " + otp)
                .create();
    System.out.println(message.getSid());
    return 1;
  }

  public boolean verifyOTP(String phoneNumber, String enteredOTP) {
    // Verify the OTP entered by the user
    PatientLogin user = userRepository.findByPhoneNumber(phoneNumber);
    if (user == null || !user.getOtpValue().equals(enteredOTP)) {
      return false;
    } else {
      // Clear the OTP from the database
      user.setOtpValue(null);
      userRepository.save(user);
      return true;
    }
  }

}

