package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return contratService.retrieveContrat(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/{id}")
    public Contrat update(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        contratService.removeContrat(id);
        return Map.of("message", "Contrat " + id + " supprimé avec succès");
    }
}
