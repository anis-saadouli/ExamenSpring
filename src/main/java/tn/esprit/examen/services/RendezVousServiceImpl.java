package tn.esprit.examen.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Medecin;
import tn.esprit.examen.entities.Patient;
import tn.esprit.examen.entities.RendezVous;
import tn.esprit.examen.entities.Specialite;
import tn.esprit.examen.repositories.MedecinRepository;
import tn.esprit.examen.repositories.PatientRepository;
import tn.esprit.examen.repositories.RendezVousRepository;

import java.time.LocalDate;
import java.util.List;
@Service

public class RendezVousServiceImpl implements RendezVousService {
    private final RendezVousRepository rendezVousRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;


    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository, PatientRepository patientRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElseThrow();
        Patient patient = patientRepository.findById(idPatient).orElseThrow();
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);
        rendezVousRepository.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepository.findByMedecin_CliniqueIdAndMedecin_Specialite(idClinique, specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepository.countByMedecin_Id(idMedecin);       }

    @Override
    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous() {
        List<RendezVous> upcomingRendezVous = rendezVousRepository.findByDateRDVAfter(LocalDate.now());
        for (RendezVous rdv : upcomingRendezVous) {
            System.out.println("La liste des RendezVous : " + rdv.getDateRDV() + " : Medecin : " + rdv.getMedecin().getNomMedecin() + " : Patient : " + rdv.getPatient().getNomPatient());
        }

}
}



