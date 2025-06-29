package com.worellana.edutechinnovators.microservice_course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "NAME")
    String nameCourse;

    @Column(name = "DESCRIPTION_COURSE")
    String descriptionCourse;

    @Column(name = "ID_INSTRUCTOR")
    Integer idInstructor;
}
