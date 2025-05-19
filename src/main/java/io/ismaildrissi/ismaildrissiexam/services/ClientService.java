package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.dtos.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);


    List<ClientDTO> findAll();

    Optional<ClientDTO> findById(Long id);


    void delete(Long id);
}