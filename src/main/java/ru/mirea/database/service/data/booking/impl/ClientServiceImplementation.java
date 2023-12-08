package ru.mirea.database.service.data.booking.impl;

import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.booking.ClientDTO;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.data.repository.booking.JpaClientRepository;
import ru.mirea.database.service.data.booking.ClientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    protected final JpaClientRepository clientRepository;

    public ClientServiceImplementation(JpaClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client save(ClientDTO client) {
        return null;
    }

    @Override
    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientDTO getClientById(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void update(ClientDTO clientDTO) {

    }
}
