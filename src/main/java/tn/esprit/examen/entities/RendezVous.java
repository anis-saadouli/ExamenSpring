package tn.esprit.examen.entities;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity


public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateRDV;
    private String remarque;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}