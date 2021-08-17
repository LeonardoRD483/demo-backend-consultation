package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "select C.* , D.id as 'doctor_id' from client C join doctor D on C.id = D.client_id ;",nativeQuery = true)
    List<JSONObject> client_and_doctorList();
}
