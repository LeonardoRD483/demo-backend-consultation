package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Doctor;
import com.example.demo.service.Implements.DoctorServiceImpl;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {


    @Autowired(required = true)
    private DoctorServiceImpl doctorService;


    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();


        List<JSONObject> list = (List<JSONObject>) doctorService.findAll();
        System.out.println("entraaaaaaaaaaaaaaa aqui");

        System.out.println(list);
        obj.put("status", true);
        obj.put("message", "success");
        obj.put("data", list);

        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @PostMapping
    public Object created(@RequestBody Doctor doctor) {
        JSONObject obj = new JSONObject();

        try {
            Doctor doctor1 = doctorService.save(doctor);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", doctor1);
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
            Optional<Doctor> client = doctorService.findBy(client_id);
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
    public Object Delete(@PathVariable(value = "id") int doctor_id) {
        doctorService.delete(doctor_id);
        JSONObject obj = new JSONObject();
        obj.put("res", "success");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
