package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Consultation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String description;

    @ManyToOne
    Patient patient;

    public Consultation() {
    }

    public Consultation(int id) {
        this.id = id;
    }


    public Consultation(int id, String description, Patient patient) {
        this.id = id;
        this.description = description;
        this.patient = patient;
    }
}
