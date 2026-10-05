package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
