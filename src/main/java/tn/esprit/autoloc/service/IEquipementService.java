package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entities.Equipement;

import java.util.List;

public interface IEquipementService {

    List<Equipement> retrieveAllEquipements();

    Equipement retrieveEquipement(Long idEquipement);

    Equipement addEquipement(Equipement equipement);

    Equipement updateEquipement(Equipement equipement);

    void removeEquipement(Long idEquipement);
}
