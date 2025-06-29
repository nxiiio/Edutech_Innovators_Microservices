package com.worellana.edutechinnovators.microservice_course.client;

import com.worellana.edutechinnovators.microservice_course.dto.InstructorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "instructor-microservice", url = "localhost:8084/api/v2/instructor")
public interface InstructorFeign {

    @GetMapping("/{id}")
    InstructorDTO getInstructorById(@PathVariable("id") Integer id);
}
