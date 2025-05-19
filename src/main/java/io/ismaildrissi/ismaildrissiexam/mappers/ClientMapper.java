package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.ClientDTO;
import io.ismaildrissi.ismaildrissiexam.entities.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    public ClientDTO toDto(Client client) {
        if (client == null) {
            return null;
        }
        
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        
        return clientDTO;
    }

    public Client toEntity(ClientDTO clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        
        return client;
    }
}