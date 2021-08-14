package com.example.demo.service;

import com.example.demo.model.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SpecialtyService {

    public Iterable<Specialty> findAll();
    public Page<Specialty> findAll(Pageable pageable);
    public Optional<Specialty> findBy(Integer id);
    public Specialty save(Specialty specialty);
    public void delete(Integer id);
}
