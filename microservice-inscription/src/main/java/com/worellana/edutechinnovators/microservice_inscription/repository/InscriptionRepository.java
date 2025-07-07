package com.worellana.edutechinnovators.microservice_inscription.repository;

import com.worellana.edutechinnovators.microservice_inscription.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    List<Inscription> findAllByIdClient(Integer clientId);
}
