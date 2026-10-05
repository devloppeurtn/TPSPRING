package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
