package tn.esprit.examen.services;

import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Patient;
import tn.esprit.examen.repositories.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    public PatientServiceImpl (PatientRepository patientRepository) {
        this.patientRepository = patientRepository; ;
    }
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository .save(patient);
    }

}
