package com.example.demo.service;

import com.example.demo.model.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ConsultationService {



    public List<Consultation> findAll();
    public Page<Consultation> findAll(Pageable pageable);
    public Optional<Consultation> findBy(Integer id);
    public Consultation save(Consultation client);
    public void delete(Integer id);
}
