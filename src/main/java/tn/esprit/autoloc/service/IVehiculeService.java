package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();

    Vehicule retrieveVehicule(Long idVehicule);

    Vehicule addVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    void removeVehicule(Long idVehicule);

    void affecterVehiculeAAgence(Long idVehicule, Long idAgence);

    void desaffecterVehiculeDAgence(Long idVehicule);

    void affecterEquipementAVehicule(Long idEquipement, Long idVehicule);

    void desaffecterEquipementDeVehicule(Long idEquipement, Long idVehicule);
}
