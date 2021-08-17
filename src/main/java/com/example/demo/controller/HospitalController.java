package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Hospital;
import com.example.demo.service.Implements.HospitalServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "*")
public class HospitalController {


    @Autowired
    private HospitalServiceImpl hospitalService;

    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();
        try {
            List<Hospital> list = (List<Hospital>) hospitalService.findAll();
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
    public Object created(@RequestBody Hospital hospital) {
        JSONObject obj = new JSONObject();
        try {
            Hospital hospital1 = hospitalService.save(hospital);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", hospital1);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Object ById(@PathVariable(value = "id") int hospital_id) {
        JSONObject obj = new JSONObject();
        try {
            Optional<Hospital> hospital = hospitalService.findBy(hospital_id);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", hospital);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public Object Update(@PathVariable(value = "id") int client_id , @RequestBody Client client) {
        JSONObject obj = new JSONObject();
        try {

            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", client);
        } catch (Exception e) {
            obj.put("status", false);
            obj.put("message", "error");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public Object DeleteTipoMedioUsuario(@PathVariable(value = "id") int doctor_id) {
        hospitalService.delete(doctor_id);
        JSONObject obj = new JSONObject();
        obj.put("res", "success");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
