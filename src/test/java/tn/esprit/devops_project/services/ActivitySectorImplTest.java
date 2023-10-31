package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.controllers.ActivitySectorController;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ActivitySectorImplTest {
    @InjectMocks
    private ActivitySectorController activitySectorController;
    @InjectMocks
    private ActivitySectorImpl service1;
@Autowired
private ActivitySectorRepository activitySectorRepository;
    @Autowired
private ActivitySectorImpl service;
    ActivitySectorImpl activitySectorService = Mockito.mock(ActivitySectorImpl.class);

    @Test
    void retrieveAllActivitySectors() {

        List<ActivitySector> retrievedActivitySectors = activitySectorController.retrieveAllActivitySectors();


        assertNotNull(retrievedActivitySectors);
    }

    @Test
    void addActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("test");
        activitySector.setLibelleSecteurActivite("new libelle");
        ActivitySector activitySector1 = service.addActivitySector(activitySector);
        assertNotNull(activitySector1);
        assertNotNull(activitySector1.getIdSecteurActivite());
        assertEquals("test" , activitySector1.getCodeSecteurActivite());
        assertEquals("new libelle",activitySector1.getLibelleSecteurActivite());

    }
   /* @Test
    void addActivitySector2() {
        ActivitySector newActivitySector = new ActivitySector();
        newActivitySector.setCodeSecteurActivite("XX");
        newActivitySector.setLibelleSecteurActivite("Sector1");
        when(activitySectorRepository.save(newActivitySector)).thenReturn(newActivitySector);
        ActivitySector savedActivitySector = activitySectorService.addActivitySector(newActivitySector);
        assertNotNull(savedActivitySector);


    }*/
    @Test
    void deleteActivitySector() {
        // Créez un secteur d'activité que vous souhaitez supprimer (ou utilisez un existant)

        // Appelez la méthode de service pour supprimer le secteur d'activité
        activitySectorService.deleteActivitySector(1L);

        // Effectuez des assertions pour vérifier que le secteur d'activité a été supprimé correctement
    }


    @Test
    void updateActivitySector() {
        // Créez un secteur d'activité existant que vous souhaitez mettre à jour
        ActivitySector existingSector = new ActivitySector();
        existingSector.setIdSecteurActivite(1L); // Remplacez par l'ID du secteur existant
        existingSector.setCodeSecteurActivite("SAE");
        existingSector.setLibelleSecteurActivite("Genielogiciel");

        // Appelez la méthode de service pour mettre à jour le secteur d'activité
        ActivitySector updatedSector = activitySectorService.updateActivitySector(existingSector);

        // Effectuez des assertions pour vérifier que le secteur d'activité a été mis à jour correctement

    }

    @Test
    void retrieveActivitySector() {
    }
}