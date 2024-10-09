package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Creneau {

    @Id @GeneratedValue
    private int idCreneau;

    private LocalDateTime debut;

    private LocalDateTime fin;

    @ManyToOne
    private Salle dans;

    @ManyToMany(mappedBy = "creneaux")
    private Set<Groupe> concerne;

}
