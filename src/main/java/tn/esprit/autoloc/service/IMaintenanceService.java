package tn.esprit.autoloc.service;

import tn.esprit.autoloc.Entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    List<Maintenance> retrieveAllMaintenances();

    Maintenance retrieveMaintenance(Long idMaintenance);

    Maintenance addMaintenance(Maintenance maintenance);

    Maintenance updateMaintenance(Maintenance maintenance);

    void removeMaintenance(Long idMaintenance);
}
