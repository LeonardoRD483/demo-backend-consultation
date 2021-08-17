package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String last_name;
    String date;
    String direction;
    String photo;


    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    public Client(String name, String last_name, String date, String direction, String photo) {
        this.name = name;
        this.last_name = last_name;
        this.date = date;
        this.direction = direction;
        this.photo = photo;
    }

}
