package tn.esprit.examen.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString

public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomMedecin;
    private String telephone;
    private Double prixConsultation;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clinique_id")
    private Clinique clinique;
@JsonIgnore
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}