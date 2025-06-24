package com.worellana.edutechinnovators.microservice_client.controller;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import com.worellana.edutechinnovators.microservice_client.entity.ClientDTO;
import com.worellana.edutechinnovators.microservice_client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/api")
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getClient(id));
    }

    @PostMapping("/api")
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addClient(client));
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Client> replaceClient(@PathVariable Integer id, @RequestBody ClientDTO client) {
        return ResponseEntity.ok(service.updateClient(id,client));
    }
}
