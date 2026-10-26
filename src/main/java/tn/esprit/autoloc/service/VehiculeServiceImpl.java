package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule updateVehicule(Vehicule vehicule) {
        Vehicule existant = retrieveVehicule(vehicule.getIdVehicule());
        vehicule.setAgence(existant.getAgence());
        vehicule.setEquipements(existant.getEquipements());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        retrieveVehicule(idVehicule);
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    @Transactional
    public void affecterVehiculeAAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
    }

    @Override
    @Transactional
    public void desaffecterVehiculeDAgence(Long idVehicule) {
        retrieveVehicule(idVehicule).setAgence(null);
    }

    @Override
    @Transactional
    public void affecterEquipementAVehicule(Long idEquipement, Long idVehicule) {
        retrieveVehicule(idVehicule).getEquipements().add(retrieveEquipement(idEquipement));
    }

    @Override
    @Transactional
    public void desaffecterEquipementDeVehicule(Long idEquipement, Long idVehicule) {
        retrieveVehicule(idVehicule).getEquipements().remove(retrieveEquipement(idEquipement));
    }

    private Equipement retrieveEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + idEquipement));
    }
}
