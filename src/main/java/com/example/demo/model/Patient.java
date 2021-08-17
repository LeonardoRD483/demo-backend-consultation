package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    Client client;


    public Patient() {
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(int id, Client client) {
        this.id = id;
        this.client = client;
    }
}
