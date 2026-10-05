package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
