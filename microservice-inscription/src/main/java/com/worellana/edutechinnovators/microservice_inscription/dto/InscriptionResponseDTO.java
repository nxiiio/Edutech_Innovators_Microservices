package com.worellana.edutechinnovators.microservice_inscription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionResponseDTO {
    Integer id;
    Date dateInscription;
    String additionalInformation;
    ClientDTO client;
    CourseDTO course;
}
