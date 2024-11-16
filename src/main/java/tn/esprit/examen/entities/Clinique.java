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
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClinique;
    private String adresse;
    private String telephone;
@JsonIgnore
    @OneToMany(mappedBy = "clinique")
    private List<Medecin> medecins;
}

