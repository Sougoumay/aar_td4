package entities;

import jakarta.persistence.*;

@Entity
public class Composant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComposant;
    private String nomComposant;
    @ManyToOne
    private Composite composite;


    public int getIdComposant() {
        return idComposant;
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public void setNomComposant(String nomComposant) {
        this.nomComposant = nomComposant;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }
}
