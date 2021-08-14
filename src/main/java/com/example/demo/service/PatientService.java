package com.example.demo.service;

import com.example.demo.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PatientService {

    public Iterable<Patient> findAll();
    public Page<Patient> findAll(Pageable pageable);
    public Optional<Patient> findBy(Integer id);
    public Patient save(Patient patient);
    public void delete(Integer id);
}
