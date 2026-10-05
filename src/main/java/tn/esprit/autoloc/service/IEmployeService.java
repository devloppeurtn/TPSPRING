package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entities.Employe;

import java.util.List;

public interface IEmployeService {

    List<Employe> retrieveAllEmployes();

    Employe retrieveEmploye(Long idEmploye);

    Employe addEmploye(Employe employe);

    Employe updateEmploye(Employe employe);

    void removeEmploye(Long idEmploye);
}
