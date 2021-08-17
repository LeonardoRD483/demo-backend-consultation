package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    Client client;

    public Doctor() {
    }

    public Doctor(int id) {
        this.id = id;
    }
}
