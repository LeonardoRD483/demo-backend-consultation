package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {


    public Iterable<User> findAll();
    public Page<User> findAll(Pageable pageable);
    public Optional<User> findBy(Integer id);
    public User save(User user);
    public void delete(Integer id);
}
