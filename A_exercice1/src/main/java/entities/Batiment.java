package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Batiment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private UFR gerePar;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Salle> salles;
}
