package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return paiementService.retrievePaiement(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement add(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement update(@PathVariable Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        paiementService.removePaiement(id);
        return Map.of("message", "Paiement " + id + " supprimé avec succès");
    }
}
