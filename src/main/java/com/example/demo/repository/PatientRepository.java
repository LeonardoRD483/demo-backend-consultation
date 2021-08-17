package com.example.demo.repository;

import com.example.demo.model.Patient;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select C.* , D.id as 'patient_id' from client C join patient D on C.id = D.client_id ;",nativeQuery = true)
    List<JSONObject> client_and_patientList();
}
