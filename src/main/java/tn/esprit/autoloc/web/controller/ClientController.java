package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.retrieveClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        client.setIdClient(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        clientService.removeClient(id);
        return Map.of("message", "Client " + id + " supprimé avec succès");
    }
}
