package com.example.demo.service.Implements;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findBy(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
