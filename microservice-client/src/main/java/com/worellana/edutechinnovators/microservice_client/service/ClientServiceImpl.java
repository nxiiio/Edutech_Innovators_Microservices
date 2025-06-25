package com.worellana.edutechinnovators.microservice_client.service;

import com.worellana.edutechinnovators.microservice_client.entity.Client;
import com.worellana.edutechinnovators.microservice_client.dto.ClientDTO;
import com.worellana.edutechinnovators.microservice_client.exception.ClientNotFoundException;
import com.worellana.edutechinnovators.microservice_client.exception.EmailAlreadyExitsException;
import com.worellana.edutechinnovators.microservice_client.exception.EmailNotFoundException;
import com.worellana.edutechinnovators.microservice_client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }

    @Override
    public Client getClient(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    @Override
    public Client addClient(ClientDTO client) {
        if (repository.existsByEmail(client.getEmail())) {
            throw new EmailAlreadyExitsException("The email already exits");
        }
        return repository.save(Client.builder()
                .name(client.getName())
                .email(client.getEmail())
                .age(client.getAge()).build());
    }

    @Override
    public Client updateClient(Integer id, ClientDTO client) {
        return repository.findById(id)
                .map(user -> {
                    if (repository.existsByEmail(client.getEmail()) &&
                        !user.getEmail().equals(client.getEmail())) {
                        throw new EmailNotFoundException("The email does not exist");
                    }
                    user.setName(client.getName());
                    user.setEmail(client.getEmail());
                    user.setAge(client.getAge());
                    return repository.save(user);
                })
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    @Override
    public void deleteClient(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found")));
    }
}
