package com.iiitb.tcp_backend.service;

import com.iiitb.tcp_backend.model.DoctorDetails;
import com.iiitb.tcp_backend.model.DoctorLogin;
import com.iiitb.tcp_backend.repository.DoctorLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorLoginService {

    @Autowired
    private DoctorLoginRepository repo;

    public DoctorLogin findById(int id)
    {
        return repo.findByDoctorId(id);
    }
    public DoctorLogin findByemail(String username)
    {
        return repo.findByDoctorEmail(username);
    }

    public DoctorLogin save(DoctorLogin movement) {
        System.out.println("Before" + movement.getDoctorEmailId());
        repo.save(movement);
        System.out.println("After"+ movement.getDoctorId());
        return movement;
    }

    public List<DoctorLogin> getDoctors()
    {
        return repo.getDoctors();
    }

}
