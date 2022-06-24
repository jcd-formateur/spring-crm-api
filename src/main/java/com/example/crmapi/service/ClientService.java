package com.example.crmapi.service;

import com.example.crmapi.model.Client;
import com.example.crmapi.model.Order;
import com.example.crmapi.repository.ClientRepository;
import com.example.crmapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
