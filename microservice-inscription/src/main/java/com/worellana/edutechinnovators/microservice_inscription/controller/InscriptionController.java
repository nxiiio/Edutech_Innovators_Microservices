package com.worellana.edutechinnovators.microservice_inscription.controller;

import com.worellana.edutechinnovators.microservice_inscription.dto.InscriptionResponseDTO;
import com.worellana.edutechinnovators.microservice_inscription.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionService service;

    @GetMapping
    public ResponseEntity<List<InscriptionResponseDTO>> getInscriptions() {
        return ResponseEntity.ok(service.getInscriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionResponseDTO> getInscriptionById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getInscription(id));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<InscriptionResponseDTO>> getInscriptionsByClientId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getInscriptionsByClientID(id));
    }
}
