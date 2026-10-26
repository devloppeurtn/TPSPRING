package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ContratRepository contratRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + idReservation));
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public Reservation updateReservation(Reservation reservation) {
        Reservation existante = retrieveReservation(reservation.getIdReservation());
        reservation.setClient(existante.getClient());
        reservation.setContrat(existante.getContrat());
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long idReservation) {
        retrieveReservation(idReservation);
        reservationRepository.deleteById(idReservation);
    }

    @Override
    @Transactional
    public void affecterContratAReservation(Long idContrat, Long idReservation) {
        Reservation reservation = retrieveReservation(idReservation);
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));
        Reservation actuelle = contrat.getReservation();
        if (actuelle != null && !actuelle.getIdReservation().equals(idReservation)) {
            throw new IllegalStateException("Le contrat " + idContrat
                    + " est déjà affecté à la réservation " + actuelle.getIdReservation());
        }
        reservation.setContrat(contrat);
    }

    @Override
    @Transactional
    public void desaffecterContratDeReservation(Long idReservation) {
        retrieveReservation(idReservation).setContrat(null);
    }

    @Override
    @Transactional
    public void affecterClientAReservation(Long idClient, Long idReservation) {
        Reservation reservation = retrieveReservation(idReservation);
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + idClient));
        reservation.setClient(client);
    }
}
