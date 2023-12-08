package ru.mirea.database.controller.booking;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.booking.BookingDTO;
import ru.mirea.database.data.dto.booking.ClientDTO;
import ru.mirea.database.data.entity.booking.Booking;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.service.data.booking.BookingService;
import ru.mirea.database.service.data.booking.ClientService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ModelAttribute("clients")
    public List<Client> clients() {
        return clientService.allClients();
    }

    @GetMapping
    public String clientView(Model model) {
        model.addAttribute("clients", clientService.allClients());
        return "booking/client";
    }

    @GetMapping("save")
    public String saveView(Model model) {
        ClientDTO input = new ClientDTO();
        model.addAttribute("input", input);
        return "booking/client_update";
    }

    @PostMapping("/save")
    public String saveClient(Model model, @Valid @ModelAttribute("input") ClientDTO client) {
        if (client.getId() == null) {
                clientService.save(client);
        } else {
            clientService.update(client);
        }
        return "redirect:/client?save=true";
    }

    @GetMapping("update/{id}")
    public String updateView(Model model, @PathVariable(name = "id") Long id) {
        ClientDTO input = clientService.getClientById(id);
        model.addAttribute("input", input);
        return "booking/client";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(Model model, @PathVariable("id") Long id) {
        try {
            clientService.deleteClientById(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/client?error=true";
        }
        return "redirect:/client?delete=true";
    }
}
