package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) {
        return agenceService.retrieveAgence(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agence add(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
    public Agence update(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        agenceService.removeAgence(id);
        return Map.of("message", "Agence " + id + " supprimé avec succès");
    }
}
