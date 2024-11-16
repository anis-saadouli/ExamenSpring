package tn.esprit.examen.services;

import tn.esprit.examen.entities.Clinique;
import tn.esprit.examen.entities.Medecin;


public interface MedecinService {
    Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);
}