package tn.esprit.examen.services;

import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Clinique;
import tn.esprit.examen.repositories.CliniqueRepository;


@Service
public class CliniqueServiceImpl implements CliniqueService {


private final CliniqueRepository cliniqueRepository;

    public CliniqueServiceImpl(CliniqueRepository cliniqueRepository) {
        this.cliniqueRepository = cliniqueRepository;
    }
    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

}
