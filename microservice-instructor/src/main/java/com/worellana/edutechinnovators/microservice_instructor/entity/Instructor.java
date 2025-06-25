package com.worellana.edutechinnovators.microservice_instructor.entity;

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
@Table(name = "INSTRUCTOR")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "NAME")
    String name;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "SPECIALIZATION")
    String specialization;
}
