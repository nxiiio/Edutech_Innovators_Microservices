package com.worellana.edutechinnovators.microservice_course.client;

import com.worellana.edutechinnovators.microservice_course.dto.InstructorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "instructor-microservice", url = "localhost:8080/api/v2/instructors")
public interface InstructorFeign {

    @GetMapping("/{id}")
    InstructorDTO getInstructorById(@PathVariable("id") Integer id);

    @GetMapping
    List<InstructorDTO> getAllInstructors();
}
