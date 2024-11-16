package tn.esprit.examen.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.Medecin;
import tn.esprit.examen.services.MedecinService;

@RestController
    @RequestMapping("/medecin")
    @RequiredArgsConstructor
    public class MedecinController {
        private final MedecinService medecinService;

        @PostMapping("/add/{cliniqueId}")
        public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long cliniqueId) {
            return medecinService.addMedecinAndAssignToClinique(medecin, cliniqueId);
        }
    }

