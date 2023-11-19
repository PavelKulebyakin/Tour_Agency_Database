package ru.mirea.database.service.data.booking.impl;

import org.springframework.stereotype.Service;
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
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) throws NoSuchElementException {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
            return client;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
