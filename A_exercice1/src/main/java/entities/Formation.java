package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Formation {

    @Id @GeneratedValue
    private String idForm;

    private String intituleForm;

    @ManyToMany(mappedBy = "reserveeA")
    private Set<Salle> reserve;

    @ManyToMany
    private Set<Groupe> groupes;

    @ManyToMany
    private Set<Etudiant> inscrits;
}
