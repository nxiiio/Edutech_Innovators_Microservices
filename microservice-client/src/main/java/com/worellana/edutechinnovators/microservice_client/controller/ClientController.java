package com.worellana.edutechinnovators.microservice_client.controller;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import com.worellana.edutechinnovators.microservice_client.dto.ClientDTO;
import com.worellana.edutechinnovators.microservice_client.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getClient(id));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDTO client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> replaceClient(@PathVariable Integer id, @Valid @RequestBody ClientDTO client) {
        return ResponseEntity.ok(service.updateClient(id,client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Integer id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
