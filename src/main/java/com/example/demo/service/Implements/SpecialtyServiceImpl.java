package com.example.demo.service.Implements;


import com.example.demo.model.Specialty;
import com.example.demo.repository.SpecialtyRepository;
import com.example.demo.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Specialty> findAll(Pageable pageable) {
        return specialtyRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Specialty> findBy(Integer id) {
        return specialtyRepository.findById(id);
    }

    @Override
    @Transactional
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        specialtyRepository.deleteById(id);
    }
}
