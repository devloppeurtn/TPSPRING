package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return maintenanceService.retrieveMaintenance(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maintenance add(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @PutMapping("/{id}")
    public Maintenance update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        return maintenanceService.updateMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        maintenanceService.removeMaintenance(id);
        return Map.of("message", "Maintenance " + id + " supprimé avec succès");
    }
}
