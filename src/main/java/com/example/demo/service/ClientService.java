package com.example.demo.service;

import com.example.demo.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService  {


    public Iterable<Client> findAll();
    public Page<Client> findAll(Pageable pageable);
    public Optional<Client> findBy(Integer id);
    public Client save(Client client);
    public void delete(Integer id);
}
