package com.worellana.edutechinnovators.microservice_course.controller;

import com.worellana.edutechinnovators.microservice_course.dto.CourseDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseResponseDTO;
import com.worellana.edutechinnovators.microservice_course.entity.Course;
import com.worellana.edutechinnovators.microservice_course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getCourses() {
        return ResponseEntity.ok(service.getCourses());
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<List<CourseResponseDTO>> getCoursesByIdInstructor(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCoursesByInstructor(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourse(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> addCourse(@Valid @RequestBody CourseDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCourse(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Integer id, @Valid @RequestBody CourseDTO request){
        return ResponseEntity.ok(service.updateCourse(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> removeCourse(@PathVariable Integer id){
        service.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
