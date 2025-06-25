package com.worellana.edutechinnovators.microservice_client.repository;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByEmail(String email);
}
