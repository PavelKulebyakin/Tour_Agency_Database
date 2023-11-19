package ru.mirea.database.controller.admin;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.service.data.booking.ClientService;

import java.util.NoSuchElementException;
import java.util.List;

@RestController
public class ClientController {                                                 // TODO: 19.11.2023 check all methods

    protected final ClientService clientService;

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

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
