package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Hospital implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String direction;

    public Hospital() {
    }

    public Hospital(int id) {
        this.id = id;
    }

    public Hospital(int id, String name, String direction) {
        this.id = id;
        this.name = name;
        this.direction = direction;
    }
}
