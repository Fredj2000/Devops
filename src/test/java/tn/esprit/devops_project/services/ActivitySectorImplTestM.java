package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
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

@SpringBootTest
class ActivitySectorImplTestM {
    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @Test
    void retrieveAllActivitySectors() {
        List<ActivitySector> activitySectors = new ArrayList<>();

        ActivitySector sector1 = new ActivitySector();
        sector1.setIdSecteurActivite(11L);
        sector1.setCodeSecteurActivite("123");
        sector1.setLibelleSecteurActivite("Coding");

        ActivitySector sector2 = new ActivitySector();
        sector2.setIdSecteurActivite(2L);
        sector2.setCodeSecteurActivite("456");
        sector2.setLibelleSecteurActivite("search");

        activitySectors.add(sector1);
        activitySectors.add(sector2);

        Mockito.when(activitySectorRepository.findAll()).thenReturn(activitySectors);

        List<ActivitySector> retrievedActivitySectors = activitySectorService.retrieveAllActivitySectors();

        Assertions.assertNotNull(retrievedActivitySectors);
        Assertions.assertEquals(2L, retrievedActivitySectors.size());
        Assertions.assertEquals("Coding", retrievedActivitySectors.get(0).getLibelleSecteurActivite());
        Assertions.assertEquals("search", retrievedActivitySectors.get(1).getLibelleSecteurActivite());
    }



    @Test
    void addActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        activitySector.setIdSecteurActivite(1L);
        activitySector.setCodeSecteurActivite("123");
        activitySector.setLibelleSecteurActivite("Coding");

        Mockito.when(activitySectorRepository.save(Mockito.any(ActivitySector.class))).thenReturn(activitySector);

        ActivitySector savedActivitySector = activitySectorService.addActivitySector(activitySector);

        Assertions.assertNotNull(savedActivitySector);
        Assertions.assertEquals(1L, savedActivitySector.getIdSecteurActivite());
        Assertions.assertEquals("123", savedActivitySector.getCodeSecteurActivite());
        Assertions.assertEquals("Coding", savedActivitySector.getLibelleSecteurActivite());
    }

    @Test
    void deleteActivitySector() {
        ActivitySector sectorToDelete = new ActivitySector();
        sectorToDelete.setIdSecteurActivite(1L);
        sectorToDelete.setCodeSecteurActivite("123");
        sectorToDelete.setLibelleSecteurActivite("Coding");

        Mockito.doNothing().when(activitySectorRepository).deleteById(sectorToDelete.getIdSecteurActivite());

        activitySectorService.deleteActivitySector(1L);

        Mockito.verify(activitySectorRepository, Mockito.times(1)).deleteById(sectorToDelete.getIdSecteurActivite());
    }


    @Test
    void updateActivitySector() {
        ActivitySector sectorToUpdate = new ActivitySector();
        sectorToUpdate.setIdSecteurActivite(1L);
        sectorToUpdate.setCodeSecteurActivite("123");
        sectorToUpdate.setLibelleSecteurActivite("Coding");

        Mockito.when(activitySectorRepository.save(sectorToUpdate)).thenReturn(sectorToUpdate);

        ActivitySector updatedSector = activitySectorService.updateActivitySector(sectorToUpdate);

        Mockito.verify(activitySectorRepository, Mockito.times(1)).save(sectorToUpdate);

        Assertions.assertEquals(sectorToUpdate, updatedSector);

    }

    @Test
    void retrieveActivitySector() {

    }
}