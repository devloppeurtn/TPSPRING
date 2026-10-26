package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Long id) {
        return reservationService.retrieveReservation(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation add(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        reservationService.removeReservation(id);
        return Map.of("message", "Reservation " + id + " supprimé avec succès");
    }

    @PutMapping("/{idReservation}/contrat/{idContrat}")
    public Map<String, String> affecterContratAReservation(@PathVariable Long idReservation, @PathVariable Long idContrat) {
        reservationService.affecterContratAReservation(idContrat, idReservation);
        return Map.of("message", "Contrat " + idContrat + " affecté à la reservation " + idReservation);
    }

    @DeleteMapping("/{idReservation}/contrat")
    public Map<String, String> desaffecterContratDeReservation(@PathVariable Long idReservation) {
        reservationService.desaffecterContratDeReservation(idReservation);
        return Map.of("message", "Contrat retiré de la reservation " + idReservation);
    }

    @PutMapping("/{idReservation}/client/{idClient}")
    public Map<String, String> affecterClientAReservation(@PathVariable Long idReservation, @PathVariable Long idClient) {
        reservationService.affecterClientAReservation(idClient, idReservation);
        return Map.of("message", "Client " + idClient + " affecté à la reservation " + idReservation);
    }
}
