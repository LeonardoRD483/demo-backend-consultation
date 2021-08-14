package com.example.demo.controller;

import com.example.demo.model.Consultation;
import com.example.demo.service.Implements.ConsultationServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultation")
@CrossOrigin(origins = "*")
public class ConsultationController {

    @Autowired(required = true)
    private ConsultationServiceImpl consultationService;


    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();

        try {
            List<Consultation> list = (List<Consultation>) consultationService.findAll();
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
    public Object created(@RequestBody Consultation consultation) {
        JSONObject obj = new JSONObject();
        try {
            Consultation consultation1 = consultationService.save(consultation);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", consultation1);
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
            Optional<Consultation> client = consultationService.findBy(client_id);
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
