package com.worellana.edutechinnovators.microservice_client.service;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import com.worellana.edutechinnovators.microservice_client.entity.ClientDTO;
import com.worellana.edutechinnovators.microservice_client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getClients() {
        return repository.findAllByOrderByIdAsc();
    }

    public Client getClient(Integer id) {
        return repository.findById(id).get();
    }

    public Client addClient(ClientDTO client) {
        if (repository.existsClientByEmail(client.getEmail())) {
            throw new RuntimeException("exits");
        }
        return repository.save(Client.builder()
                .name(client.getName())
                .email(client.getEmail())
                .age(client.getAge()).build());
    }

    public Client updateClient(Integer id, ClientDTO client) {
        return repository.findById(id)
                .map(user -> {
                    if (repository.existsClientByEmail(client.getEmail()) &&
                        !user.getEmail().equals(client.getEmail())) {
                        throw new RuntimeException("El correo ya existe");
                    }
                    user.setName(client.getName());
                    user.setEmail(client.getEmail());
                    user.setAge(client.getAge());
                    return repository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }
}
