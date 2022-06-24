package com.example.crmapi.dto;

import com.example.crmapi.model.Client;

public class ClientMapper {

    public static ClientDTO buildClientDTO(Client client) {

        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setCompanyName(client.getCompanyName());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setAddress(client.getAddress());
        dto.setZipCode(client.getZipCode());
        dto.setCity(client.getCity());
        dto.setCountry(client.getCountry());

        switch (client.getState()) {
            case 0:
                dto.setState("INACTIVE");
                break;
            case 1:
                dto.setState("ACTIVE");
                break;
            default:
                dto.setState("");
        }
        return dto;
    }

    public static Client buildClient(ClientDTO clientDTO) {

        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setCompanyName(clientDTO.getCompanyName());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setAddress(clientDTO.getAddress());
        client.setZipCode(clientDTO.getZipCode());
        client.setCity(clientDTO.getCity());
        client.setCountry(clientDTO.getCountry());

        switch (clientDTO.getState()) {
            case "INACTIVE":
                client.setState(0);
                break;
            case "ACTIVE":
                client.setState(1);
                break;
            default:
                client.setState(0);
        }
        return client;
    }
}
