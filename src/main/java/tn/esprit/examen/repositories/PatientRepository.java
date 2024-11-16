package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
