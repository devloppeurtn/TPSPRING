package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) {
        return equipementService.retrieveEquipement(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement add(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping("/{id}")
    public Equipement update(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        return equipementService.updateEquipement(equipement);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        equipementService.removeEquipement(id);
        return Map.of("message", "Equipement " + id + " supprimé avec succès");
    }
}
