package tn.esprit.examen.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.Clinique;
import tn.esprit.examen.services.CliniqueService;

@RestController
@RequestMapping("/clinique")
@RequiredArgsConstructor
public class CliniqueController {
    private final CliniqueService cliniqueService;

    @PostMapping("/add")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return cliniqueService.addClinique(clinique);
    }
}
