package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
        return Map.of("message", "Vehicule " + id + " supprimé avec succès");
    }
}
