package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue
    @Column(name = "idForm")
    private int id;

    @Column(name = "intituleForm")
    private String intitule;
}
