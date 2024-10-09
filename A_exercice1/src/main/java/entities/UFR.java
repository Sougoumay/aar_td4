package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UFR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUFR;

    private String sigleUFR;

    @OneToMany(mappedBy = "gerePar")
    private List<Batiment> batiments;
}
