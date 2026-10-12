package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : " + idMaintenance));
    }

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        retrieveMaintenance(maintenance.getIdMaintenance());
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        retrieveMaintenance(idMaintenance);
        maintenanceRepository.deleteById(idMaintenance);
    }
}
