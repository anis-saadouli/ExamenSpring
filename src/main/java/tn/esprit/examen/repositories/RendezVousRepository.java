package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.RendezVous;
import tn.esprit.examen.entities.Specialite;

import java.time.LocalDate;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByMedecin_CliniqueIdAndMedecin_Specialite(Long cliniqueId, Specialite specialite);
    int countByMedecin_Id(Long medecinId);
    List<RendezVous> findByDateRDVAfter(LocalDate date);
}