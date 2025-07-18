package com.worellana.edutechinnovators.microservice_course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private CategoryDTO category;
    private InstructorDTO instructor;
}
