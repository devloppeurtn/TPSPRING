package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
