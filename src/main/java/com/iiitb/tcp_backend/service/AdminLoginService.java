package com.iiitb.tcp_backend.service;


import com.iiitb.tcp_backend.model.AdminLogin;

import com.iiitb.tcp_backend.repository.AdminLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminLoginService {

    @Autowired
    private AdminLoginRepository repo;

    public AdminLogin findById(int id)
    {
        return repo.findByAdminId(id);
    }
    public AdminLogin findByemail(String username)
    {
        return repo.findByAdminEmail(username);
    }
    public AdminLogin save(AdminLogin movement) {
        System.out.println("Before" + movement.getAdminEmailId());
        repo.save(movement);
        System.out.println("After"+ movement.getAdminId());
        return movement;
    }

    public List<AdminLogin> getAdmins()
    {
        return repo.getAdmins();
    }
}
