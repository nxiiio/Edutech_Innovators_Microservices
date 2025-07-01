package com.worellana.edutechinnovators.microservice_course.dto;

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

public class CourseRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Integer idCategory;

    @NotNull
    private Integer idInstructor;
}
