package tn.esprit.examen.services;

import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Clinique;
import tn.esprit.examen.entities.Medecin;
import tn.esprit.examen.repositories.CliniqueRepository;
import tn.esprit.examen.repositories.MedecinRepository;


@Service
public class MedecinServiceImp implements MedecinService {


    private final MedecinRepository medecinRepository;
    private final CliniqueRepository cliniqueRepository;


    public MedecinServiceImp(MedecinRepository medecinRepository, CliniqueRepository cliniqueRepository) {
        this.medecinRepository = medecinRepository;
        this.cliniqueRepository = cliniqueRepository;

    }


    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElseThrow();
        medecin.setClinique(clinique);
        return medecinRepository.save(medecin);
    }

}
