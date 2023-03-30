package com.iiitb.tcp_backend.service;


import com.iiitb.tcp_backend.model.Admin;
import com.iiitb.tcp_backend.repository.AdminDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminDetailsService {
    @Autowired
    private AdminDetailsRepository repo;
    public Admin findById(String id)
    {
        return repo.findByAdminId(id);
    }

    public Admin save(Admin movement) {
        //System.out.println(movement.getDoctorId());
        repo.save(movement);
        //System.out.println(movement.getDoctorId());
        return movement;
    }

    public List<Admin> getAdminList()
    {
        return repo.getAdmins();
    }

}
