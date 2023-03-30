package com.iiitb.tcp_backend.repository;
import com.iiitb.tcp_backend.model.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, String>{
    @Query(value = "SELECT * FROM doctor_details WHERE doctor_id = :id", nativeQuery = true)
    DoctorDetails findByDoctorId(@Param("id") int id);

    //@Query()
   
    @Query(value = "SELECT * FROM doctor_details INNER JOIN doctor_login ON doctor_details.doctor_id=doctor_login.doctor_id;", nativeQuery = true)
    List<DoctorDetails> getDoctors();

    @Query(value = "SELECT distinct department_name FROM doctor_details", nativeQuery = true)
    List<String> getDepartments();

    @Query(value = "SELECT count(department_name) FROM doctor_details where doctor_availability = true and  department_name = :department", nativeQuery = true)
    int countDepartment(@Param("department") String department);
}
