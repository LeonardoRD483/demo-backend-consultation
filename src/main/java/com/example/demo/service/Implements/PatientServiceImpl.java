package com.example.demo.service.Implements;


import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<JSONObject> findAll() {
        return patientRepository.client_and_patientList();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Patient> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> findBy(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }
}
