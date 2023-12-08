package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.dto.booking.ClientDTO;
import ru.mirea.database.data.entity.booking.Client;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ClientService {

    Client save(ClientDTO client);

    List<Client> allClients();

    ClientDTO getClientById(Long id) throws NoSuchElementException;

    void deleteClientById(Long id);

    void update(ClientDTO clientDTO);
}
