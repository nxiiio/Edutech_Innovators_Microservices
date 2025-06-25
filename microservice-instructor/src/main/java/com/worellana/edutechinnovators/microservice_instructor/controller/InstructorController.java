package com.worellana.edutechinnovators.microservice_instructor.controller;

import com.worellana.edutechinnovators.microservice_instructor.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_instructor.entity.Instructor;
import com.worellana.edutechinnovators.microservice_instructor.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/instructor")
public class InstructorController {
    
    @Autowired
    private InstructorService service;
    
    @GetMapping
    public ResponseEntity<List<Instructor>> getInstructors() {
        return ResponseEntity.ok(service.getInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getInstructor(id));
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@Valid @RequestBody InstructorDTO instructor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addInstructor(instructor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> replaceInstructor(@PathVariable Integer id, @Valid @RequestBody InstructorDTO instructor) {
        return ResponseEntity.ok(service.updateInstructor(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Integer id) {
        service.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
    
}
