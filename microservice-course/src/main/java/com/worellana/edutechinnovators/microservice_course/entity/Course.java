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
    @Column(name = "ID_COURSE")
    Integer id;

    @Column(name = "NAME_COURSE")
    String nameCourse;

    @Column(name = "DESCRIPTION_COURSE")
    String descriptionCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY", nullable = false)
    Category category;

    @Column(name = "ID_INSTRUCTOR")
    Integer idInstructor;
}
