package com.worellana.edutechinnovators.microservice_course.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO {
    @NotBlank
    private String nameCourse;

    @NotBlank
    private String descriptionCourse;

    @NotNull
    private Integer idInstructor;
}
