package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "groupe")
public class Groupe {

    @Id
    @GeneratedValue
    @Column(name = "idGroupe")
    private int id;

    @Column(name = "intitule", nullable = false)
    private String intituleGroupe;

    // TODO : c'est quoi un evendriven, representer les données comme un flux, c'est à dire faire toujours des inserts et jamais des updates. Définition ) vérifier
}
