package ru.mirea.database.service;

import ru.mirea.database.data.entity.booking.Client;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);

    List<Client> allClients();

    Optional<Client> getClientById(Long id) throws NoSuchElementException;

}
