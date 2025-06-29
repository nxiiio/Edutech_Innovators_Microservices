package com.worellana.edutechinnovators.microservice_course.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String nameCourse;
    private String descriptionCourse;

    private InstructorDTO instructor;
}
