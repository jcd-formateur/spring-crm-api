package com.example.crmapi.controller;

import com.example.crmapi.dto.ClientDTO;
import com.example.crmapi.dto.ClientMapper;
import com.example.crmapi.model.Client;
import com.example.crmapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<ClientDTO> getAll() {

        List<Client> clients = clientService.getClients();
        List<ClientDTO> dtos = new ArrayList<>();
        for(Client client: clients){
            dtos.add(ClientMapper.buildClientDTO(client));
        }
        return dtos;
    }

    @GetMapping("clients/{id}")
    public ClientDTO getOneById(@PathVariable("id") Long id) {

        Client entity = clientService.getClientById(id);
        ClientDTO dto = ClientMapper.buildClientDTO(entity);
        return dto;
    }

    @PostMapping("clients")
    public void createClient(@RequestBody ClientDTO clientDTO) {

        Client client = ClientMapper.buildClient(clientDTO);
        clientService.createClient(client);
    }

    @PutMapping("clients/{id}")
    public void updateClient(@RequestBody ClientDTO clientDTO) {

        Client client = ClientMapper.buildClient(clientDTO);
        clientService.updateClient(client);
    }

    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }

}
