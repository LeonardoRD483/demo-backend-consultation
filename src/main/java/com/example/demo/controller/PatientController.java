package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.Implements.PatientServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired(required = true)
    private PatientServiceImpl patientService;


    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();

        try {
            List<Patient> list = (List<Patient>) patientService.findAll();
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", list);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @PostMapping
    public Object created(@RequestBody Patient patient) {
        JSONObject obj = new JSONObject();
        try {
            Patient patient1 = patientService.save(patient);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", patient1);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Object ById(@PathVariable(value = "id") int client_id) {
        JSONObject obj = new JSONObject();
        try {
            Optional<Patient> client = patientService.findBy(client_id);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", client);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

}

