package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "etudaint")
public class Etudiant {

    @Id
    @GeneratedValue
    @Column(name = "numEtu")
    private String id;

    @Column(name = "nomEtu")
    private String nom;

    @Column(name = "prenomEtu")
    private String prenom;

    @ManyToOne
    @JoinTable(name = "inscrits", joinColumns={@JoinColumn(name = "numEtu")}, inverseJoinColumns = {@JoinColumn(name = "idForm")})
    private Formation formation;

    @ManyToMany
    @JoinTable(name = "membres", joinColumns = {@JoinColumn(name = "numEtu")}, inverseJoinColumns = {@JoinColumn(name = "idGroupe")})
    private Set<Groupe> groupes;
}
