package com.example.demo.controller;

import com.example.demo.model.Specialty;
import com.example.demo.service.Implements.SpecialtyServiceImpl;
import com.example.demo.service.SpecialtyService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialty")
@CrossOrigin(origins = "*")
public class SpecialtyController {


    @Autowired(required = true)
    private SpecialtyServiceImpl specialtyService;


    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();

        try {
            List<Specialty> list = (List<Specialty>) specialtyService.findAll();
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
    public Object created(@RequestBody Specialty specialty) {
        JSONObject obj = new JSONObject();
        try {
            Specialty specialty1 = specialtyService.save(specialty);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", specialty1);
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
            Optional<Specialty> client = specialtyService.findBy(client_id);
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
