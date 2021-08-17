package com.example.demo.service;

import com.example.demo.model.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    public List<Hospital> findAll();
    public Page<Hospital> findAll(Pageable pageable);
    public Optional<Hospital> findBy(Integer id);
    public Hospital save(Hospital hospital);
    public void delete(Integer id);
}
