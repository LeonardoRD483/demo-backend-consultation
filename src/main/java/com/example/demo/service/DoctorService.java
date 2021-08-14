package com.example.demo.service;

import com.example.demo.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DoctorService {



    public Iterable<Doctor> findAll();
    public Page<Doctor> findAll(Pageable pageable);
    public Optional<Doctor> findBy(Integer id);
    public Doctor save(Doctor doctor);
    public void delete(Integer id);
}
