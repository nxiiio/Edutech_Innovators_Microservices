package com.worellana.edutechinnovators.microservice_inscription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INSCRIPTION")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSCRIPTION")
    Integer id;

    @Column(name = "DATE_INSCRIPTION")
    Date dateInscription;

    @Column(name = "ADDITIONAL_INFORMATION")
    String additionalInformation;

    @Column(name = "ID_CLIENT")
    Integer idClient;

    @Column(name = "ID_COURSE")
    Integer idCourse;
}
