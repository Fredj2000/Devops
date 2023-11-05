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
        activitySector.setCodeSecteurActivite("Welcom");
        activitySector.setLibelleSecteurActivite("new libelle");
        ActivitySector activitySector1 = service.addActivitySector(activitySector);
        assertNotNull(activitySector1);
        assertNotNull(activitySector1.getIdSecteurActivite());
        assertEquals("Welcom" , activitySector1.getCodeSecteurActivite());
        assertEquals("new libelle",activitySector1.getLibelleSecteurActivite());

    }

    @Test
    void deleteActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        activitySector.setIdSecteurActivite(2L);
        activitySector.setCodeSecteurActivite("Welcom");
        activitySector.setLibelleSecteurActivite("new libelle");
        activitySectorService.addActivitySector(activitySector);

        activitySectorService.deleteActivitySector(2L);

    }


    @Test
    void updateActivitySector() {
        ActivitySector existingSector = new ActivitySector();
        existingSector.setIdSecteurActivite(1L);
        existingSector.setCodeSecteurActivite("Hello");
        existingSector.setLibelleSecteurActivite("School");
        activitySectorService.updateActivitySector(existingSector);


    }

    @Test
    void retrieveActivitySector() {
    }
}