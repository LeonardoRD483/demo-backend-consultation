package com.example.demo.service.Implements;


import com.example.demo.model.Consultation;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Consultation> findAll(Pageable pageable) {
        return consultationRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Consultation> findBy(Integer id) {
        return consultationRepository.findById(id);
    }

    @Override
    @Transactional
    public Consultation save(Consultation client) {
        return consultationRepository.save(client);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        consultationRepository.deleteById(id);
    }
}
