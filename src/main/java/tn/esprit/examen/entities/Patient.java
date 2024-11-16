package tn.esprit.examen.entities;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomPatient;
    private String telephone;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous;
}