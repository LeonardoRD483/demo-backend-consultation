package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DoctorService {



    public Iterable<JSONObject> findAll();
    public Page<Doctor> findAll(Pageable pageable);
    public Optional<Doctor> findBy(Integer id);
    public Doctor save(Doctor doctor);
    public void delete(Integer id);
}
