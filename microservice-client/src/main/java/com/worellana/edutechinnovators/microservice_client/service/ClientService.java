package com.worellana.edutechinnovators.microservice_client.service;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import com.worellana.edutechinnovators.microservice_client.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client getClient(Integer id);
    Client addClient(ClientDTO client);
    Client updateClient(Integer id, ClientDTO client);
    void deleteClient(Integer id);

}
