package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client saveClient(Client client);
    void deleteClient(Long id);
}