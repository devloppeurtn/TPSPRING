package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entities.Reservation;

import java.util.List;

public interface IReservationService {

    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(Long idReservation);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void removeReservation(Long idReservation);

    void affecterContratAReservation(Long idContrat, Long idReservation);

    void desaffecterContratDeReservation(Long idReservation);

    void affecterClientAReservation(Long idClient, Long idReservation);
}
