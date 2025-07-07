package com.worellana.edutechinnovators.microservice_instructor.controller;

import com.worellana.edutechinnovators.microservice_instructor.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_instructor.entity.Instructor;
import com.worellana.edutechinnovators.microservice_instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id) {
        return ResponseEntity.ok(instructorService.getInstructor(id));
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody InstructorDTO instructorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.addInstructor(instructorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, @RequestBody InstructorDTO instructorDTO) {
        return ResponseEntity.ok(instructorService.updateInstructor(id, instructorDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
