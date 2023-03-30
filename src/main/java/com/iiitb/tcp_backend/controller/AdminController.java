package com.iiitb.tcp_backend.controller;



import com.iiitb.tcp_backend.clientmodels.AdminDetails;
import com.iiitb.tcp_backend.clientmodels.Doctor;
import com.iiitb.tcp_backend.model.Admin;
import com.iiitb.tcp_backend.model.AdminLogin;
import com.iiitb.tcp_backend.model.DoctorDetails;
import com.iiitb.tcp_backend.model.DoctorLogin;
import com.iiitb.tcp_backend.service.AdminDetailsService;
import com.iiitb.tcp_backend.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {
    @Autowired
    AdminDetailsService admin_service;
    @Autowired
    AdminLoginService admin_login_service;

    @PostMapping("/PostAdminDetails")
    public ResponseEntity<String> addDoctor(@RequestBody AdminDetails admindetails) {
        try {
            //System.out.println("asdfhj");
            String ans = "";
            int flag = 1;


            List<AdminLogin> adminLogins = admin_login_service.getAdmins();

            for(int i=0; i<adminLogins.size(); i++)
            {
                if(adminLogins.get(i).getAdminEmailId().equalsIgnoreCase(admindetails.getEmail_id())){
                    flag = 0;
                    break;
                }
            }

            if(flag==1)
            {
                Admin admin = new Admin(admindetails.getName(), admindetails.getGender(),admindetails.getDob(), admindetails.getPhone_number());
                admin = admin_service.save(admin);
                AdminLogin adminLogin = new AdminLogin(admindetails.getEmail_id(),admindetails.getPassword(),admin.getAdminId(), true);
                adminLogin = admin_login_service.save(adminLogin);

                ans = "Success";
            }
            else
                ans = "Failed. Email Id is already existing.";

            return new ResponseEntity<>(ans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/GetAdminsList")
    public ResponseEntity<List<AdminDetails>> sendAdminList(){

        try{
            List<AdminDetails> adminDetails = new ArrayList<AdminDetails>();
            List<Admin> admins = admin_service.getAdminList();

            //System.out.println(doctorDetails.toString());

            for (int i=0 ; i<admins.size() ; i++)
            {
                Admin singleAdmin = admins.get(i);

                String name = singleAdmin.getAdminName();
                Date dob = singleAdmin.getAdminDob();
                int id = singleAdmin.getAdminId();
                String gender = singleAdmin.getAdminGender();
                String email_id = "nobody@gmail.com";
                String phone_number = singleAdmin.getAdminPhoneNumber();
                String password = "qwertyjhgsa";

                AdminLogin adLogin = admin_login_service.findById(id);
                Admin admin1;

                if (adLogin.getIsAdminActive()==true){
                    AdminDetails admin = new AdminDetails(id,name, dob, gender, email_id, password, phone_number);
                    adminDetails.add(admin);
            }


            }

            for(int i=0 ; i<adminDetails.size() ; i++)
            {
                System.out.println(adminDetails.get(i).toString());
            }

            return new ResponseEntity<>(adminDetails, HttpStatus.OK);

        }

        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @DeleteMapping("/DeleteAdmin")
    public ResponseEntity<String> deleteAdmin(@RequestParam int adminId)
    {
        try
        {
            AdminLogin adminLoginDetails = admin_login_service.findById(adminId);
            adminLoginDetails.setIsAdminActive(false);
            admin_login_service.save(adminLoginDetails);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
