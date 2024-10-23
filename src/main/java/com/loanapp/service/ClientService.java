package com.loanapp.service;

import com.loanapp.model.Client;
import com.loanapp.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> searchClients(String query) {
        return clientRepository.searchByQuery(query);
    }
}

