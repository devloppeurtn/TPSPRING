package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratRepository contratRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + idPaiement));
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    @Transactional
    public Paiement updatePaiement(Paiement paiement) {
        Paiement existant = retrievePaiement(paiement.getIdPaiement());
        paiement.setContrat(existant.getContrat());
        return paiementRepository.save(paiement);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        retrievePaiement(idPaiement);
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    @Transactional
    public void affecterPaiementAContrat(Long idPaiement, Long idContrat) {
        Paiement paiement = retrievePaiement(idPaiement);
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));
        paiement.setContrat(contrat);
    }
}
