package com.worellana.edutechinnovators.microservice_inscription.client;

import com.worellana.edutechinnovators.microservice_inscription.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "course-microservice", url = "course-microservice:8082/api/v2/courses")
public interface CourseFeign {

    @GetMapping
    List<CourseDTO> getCourses();

    @GetMapping("/{id}")
    CourseDTO getCourse(@PathVariable Integer id);
}
