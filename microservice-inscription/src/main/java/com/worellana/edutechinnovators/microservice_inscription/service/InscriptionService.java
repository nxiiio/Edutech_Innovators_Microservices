package com.worellana.edutechinnovators.microservice_inscription.service;

import com.worellana.edutechinnovators.microservice_inscription.dto.InscriptionResponseDTO;

import java.util.List;

public interface InscriptionService {
    List<InscriptionResponseDTO> getInscriptions();
    InscriptionResponseDTO getInscription(Integer id);
    List<InscriptionResponseDTO> getInscriptionsByClientID(Integer id);
}
