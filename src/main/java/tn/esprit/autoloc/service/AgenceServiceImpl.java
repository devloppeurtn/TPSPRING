package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        retrieveAgence(agence.getIdAgence());
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long idAgence) {
        retrieveAgence(idAgence);
        agenceRepository.deleteById(idAgence);
    }
}
