package com.example.demo.service.Implements;

import com.example.demo.model.Client;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<JSONObject> findAll() {
        return doctorRepository.client_and_doctorList();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Doctor> findAll(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findBy(Integer id) {
        return doctorRepository.findById(id);
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        doctorRepository.deleteById(id);
    }
}
