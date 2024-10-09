package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class Etudiant {

    @Id
    private String numEtudiant;

    private String nom;

    private String prenom;

    @ManyToMany(mappedBy = "membres")
    private Set<Groupe> appartient;

    @ManyToMany(mappedBy = "inscrits")
    private Set<Formation> inscritEn;
}
