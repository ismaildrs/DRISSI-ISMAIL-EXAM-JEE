package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.dtos.ClientDTO;
import io.ismaildrissi.ismaildrissiexam.entities.Client;
import io.ismaildrissi.ismaildrissiexam.mappers.ClientMapper;
import io.ismaildrissi.ismaildrissiexam.repositories.ClientRepository;
import io.ismaildrissi.ismaildrissiexam.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientDTO> findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}