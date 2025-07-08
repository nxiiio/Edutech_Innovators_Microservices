package com.worellana.edutechinnovators.microservice_inscription.client;

import com.worellana.edutechinnovators.microservice_inscription.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-microservice", url = "client-microservice:8081/api/v2/clients")
public interface ClientFeign {
    @GetMapping
    List<ClientDTO> getClients();

    @GetMapping("/{id}")
    ClientDTO getClientById(@PathVariable("id") Integer id);
}
