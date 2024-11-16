package tn.esprit.examen.services;

import tn.esprit.examen.entities.RendezVous;
import tn.esprit.examen.entities.Specialite;

import java.util.List;

public interface RendezVousService {

    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    int getNbrRendezVousMedecin(Long idMedecin);
    void retrieveRendezVous();
}
