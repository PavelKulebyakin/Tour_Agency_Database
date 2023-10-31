package ru.mirea.database.controller;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.service.ClientService;

import java.util.NoSuchElementException;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.allClients(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) throws NoSuchElementException {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.FOUND);
    }

    @PostMapping("/client/register")
    public ResponseEntity<Client> registerClient(@RequestBody @Valid Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    // TODO: 31.10.2023 delete client method

}
