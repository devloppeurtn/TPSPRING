package tn.esprit.autoloc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.Entities.enums.CategorieVehicule;
import tn.esprit.autoloc.Entities.enums.StatutVehicule;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
@Slf4j
public class DemoDataLoader implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public void run(String... args) {
        if (vehiculeRepository.count() > 0) {
            log.info("Données de démonstration déjà présentes, insertion ignorée");
            return;
        }

        List<Vehicule> vehicules = List.of(
                vehicule("123 TU 4567", "Peugeot", "208", CategorieVehicule.CITADINE,
                        "90.00", StatutVehicule.DISPONIBLE),
                vehicule("234 TU 5678", "Volkswagen", "Passat", CategorieVehicule.BERLINE,
                        "150.00", StatutVehicule.DISPONIBLE),
                vehicule("345 TU 6789", "Kia", "Sportage", CategorieVehicule.SUV,
                        "180.00", StatutVehicule.MAINTENANCE)
        );
        vehiculeRepository.saveAll(vehicules);
        log.info("{} véhicules de démonstration insérés", vehicules.size());
    }

    private static Vehicule vehicule(String immatriculation, String marque, String modele,
                                     CategorieVehicule categorie, String tarifJournalier,
                                     StatutVehicule statut) {
        Vehicule vehicule = new Vehicule();
        vehicule.setImmatriculation(immatriculation);
        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setCategorie(categorie);
        vehicule.setTarifJournalier(new BigDecimal(tarifJournalier));
        vehicule.setStatut(statut);
        return vehicule;
    }
}
