package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Adresse {
    @Id @GeneratedValue
    private int idAdresse;
    private String rue;
    private String codepostal;
    private String ville;
    @ManyToOne
    private Pays pays;
}
