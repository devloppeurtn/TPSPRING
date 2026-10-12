package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping
    public List<Employe> getAll() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) {
        return employeService.retrieveEmploye(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe add(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping("/{id}")
    public Employe update(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        employeService.removeEmploye(id);
        return Map.of("message", "Employe " + id + " supprimé avec succès");
    }
}
