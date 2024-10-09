package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Salle {

    @Id @GeneratedValue
    private String numSalle;

    private int capacite;

    @ManyToMany
    private Set<Formation> reserveeA;

    @OneToMany(mappedBy = "dans")
    private Set<Creneau> occupation;



}
