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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ActivitySectorImplTestM {
    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @Test
    void retrieveAllActivitySectors() {
        // Créez une liste de secteurs d'activité simulée
        List<ActivitySector> activitySectors = new ArrayList<>();

        // Ajoutez des secteurs d'activité  à la liste
        ActivitySector sector1 = new ActivitySector();
        sector1.setIdSecteurActivite(11L);
        sector1.setCodeSecteurActivite("123");
        sector1.setLibelleSecteurActivite("Informatique");

        ActivitySector sector2 = new ActivitySector();
        sector2.setIdSecteurActivite(2L);
        sector2.setCodeSecteurActivite("456");
        sector2.setLibelleSecteurActivite("Finance");

        activitySectors.add(sector1);
        activitySectors.add(sector2);

        // Configurez le comportement simulé du référentiel pour la méthode findAll
        Mockito.when(activitySectorRepository.findAll()).thenReturn(activitySectors);

        // Appelez la méthode que vous souhaitez tester
        List<ActivitySector> retrievedActivitySectors = activitySectorService.retrieveAllActivitySectors();

        // Effectuez des assertions pour vérifier le résultat
        Assertions.assertNotNull(retrievedActivitySectors);
        Assertions.assertEquals(2L, retrievedActivitySectors.size());
        Assertions.assertEquals("Informatique", retrievedActivitySectors.get(0).getLibelleSecteurActivite());
        Assertions.assertEquals("Finance", retrievedActivitySectors.get(1).getLibelleSecteurActivite());
    }



    @Test
    void addActivitySector() {
        // Créez un objet ActivitySector simulé
        ActivitySector activitySector = new ActivitySector();
        activitySector.setIdSecteurActivite(1L);
        activitySector.setCodeSecteurActivite("123");
        activitySector.setLibelleSecteurActivite("Informatique");

        // Configurez le comportement simulé du référentiel pour la méthode save
        Mockito.when(activitySectorRepository.save(Mockito.any(ActivitySector.class))).thenReturn(activitySector);

        // Appelez la méthode que vous souhaitez tester
        ActivitySector savedActivitySector = activitySectorService.addActivitySector(activitySector);

        // Effectuez des assertions pour vérifier le résultat
        Assertions.assertNotNull(savedActivitySector);
        Assertions.assertEquals(1L, savedActivitySector.getIdSecteurActivite());
        Assertions.assertEquals("123", savedActivitySector.getCodeSecteurActivite());
        Assertions.assertEquals("Informatique", savedActivitySector.getLibelleSecteurActivite());
    }

    @Test
    void deleteActivitySector() {
        // Créez un secteur d'activité simulé que vous souhaitez supprimer
        ActivitySector sectorToDelete = new ActivitySector();
        sectorToDelete.setIdSecteurActivite(1L);
        sectorToDelete.setCodeSecteurActivite("123");
        sectorToDelete.setLibelleSecteurActivite("Informatique");

        // Configurez le comportement simulé du référentiel pour la méthode deleteById
        Mockito.doNothing().when(activitySectorRepository).deleteById(sectorToDelete.getIdSecteurActivite());

        // Appelez la méthode que vous souhaitez tester pour supprimer le secteur d'activité
        activitySectorService.deleteActivitySector(1L);

        // Vérifiez que la méthode deleteById du référentiel a été appelée avec l'ID du secteur d'activité à supprimer
        Mockito.verify(activitySectorRepository, Mockito.times(1)).deleteById(sectorToDelete.getIdSecteurActivite());
    }


    @Test
    void updateActivitySector() {
        // Créez un secteur d'activité simulé que vous souhaitez mettre à jour
        ActivitySector sectorToUpdate = new ActivitySector();
        sectorToUpdate.setIdSecteurActivite(1L);
        sectorToUpdate.setCodeSecteurActivite("123");
        sectorToUpdate.setLibelleSecteurActivite("Informatique");

        // Configurez le comportement simulé du référentiel pour la méthode save
        Mockito.when(activitySectorRepository.save(sectorToUpdate)).thenReturn(sectorToUpdate);

        // Appelez la méthode que vous souhaitez tester pour mettre à jour le secteur d'activité
        ActivitySector updatedSector = activitySectorService.updateActivitySector(sectorToUpdate);

        // Vérifiez que la méthode save du référentiel a été appelée avec le secteur d'activité à mettre à jour
        Mockito.verify(activitySectorRepository, Mockito.times(1)).save(sectorToUpdate);

        // Vérifiez que le secteur d'activité renvoyé par la méthode est celui que vous attendez
        Assertions.assertEquals(sectorToUpdate, updatedSector);

    }

    @Test
    void retrieveActivitySector() {
    }
}