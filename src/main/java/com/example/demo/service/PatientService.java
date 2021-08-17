package com.example.demo.service;

import com.example.demo.model.Patient;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public List<JSONObject> findAll();
    public Page<Patient> findAll(Pageable pageable);
    public Optional<Patient> findBy(Integer id);
    public Patient save(Patient patient);
    public void delete(Integer id);
}
