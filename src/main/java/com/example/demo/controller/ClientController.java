package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.Implements.ClientServiceImpl;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired(required = true)
    private ClientServiceImpl clientService;


    @GetMapping
    public Object getAllClient() {
        JSONObject obj = new JSONObject();

        try {
            List<Client> list = (List<Client>) clientService.findAll();
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
    public Object created(@RequestBody Client client) {
        JSONObject obj = new JSONObject();
        try {
            Client client1 = clientService.save(client);
            obj.put("status", true);
            obj.put("message", "success");
            obj.put("data", client1);
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
            Optional<Client> client = clientService.findBy(client_id);
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
