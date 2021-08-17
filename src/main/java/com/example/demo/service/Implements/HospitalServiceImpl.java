package com.example.demo.service.Implements;

import com.example.demo.model.Hospital;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Hospital> findAll() {

        return hospitalRepository.findAll();
    }

    @Override
    public Page<Hospital> findAll(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    @Override
    public Optional<Hospital> findBy(Integer id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void delete(Integer id) {
        hospitalRepository.deleteById(id);
    }
}
