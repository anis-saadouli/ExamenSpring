package tn.esprit.examen.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.RendezVous;
import tn.esprit.examen.entities.Specialite;
import tn.esprit.examen.services.RendezVousService;

import java.util.List;

@RestController
@RequestMapping("/rdv")
@RequiredArgsConstructor
public class RendezVousController {
    private final RendezVousService rendezVousService;

    @PostMapping("/add/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(
            @RequestBody RendezVous rdv,
            @PathVariable Long idMedecin,
            @PathVariable Long idPatient) {
        rendezVousService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }

    @GetMapping("/clinique/{idClinique}/specialite/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(
            @PathVariable Long idClinique,
            @PathVariable Specialite specialite) {
        return rendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("/medecin/{idMedecin}/count")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin) {
        return rendezVousService.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/retrieve")
    public void retrieveRendezVous() {
        rendezVousService.retrieveRendezVous();
    }
}