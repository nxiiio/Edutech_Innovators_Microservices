package com.worellana.edutechinnovators.microservice_instructor.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    @NotBlank
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String specialization;
}
