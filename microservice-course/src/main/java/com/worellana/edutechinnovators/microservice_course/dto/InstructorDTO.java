package com.worellana.edutechinnovators.microservice_course.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    Integer id;
    String name;
    String email;
    String specialization;
}
