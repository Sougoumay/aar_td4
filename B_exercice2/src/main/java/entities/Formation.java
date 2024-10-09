package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue
    @Column(name = "idForm")
    private int id;

    @Column(name = "intituleForm")
    private String intitule;

    @OneToMany(mappedBy = "formation")
    private Set<Etudiant> etudiants;
}
