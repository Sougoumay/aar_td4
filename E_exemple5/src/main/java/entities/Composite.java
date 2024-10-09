package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Composite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComposite;
    private String nomComposite;
    @OneToMany(mappedBy = "composite", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Composant> composants;

    public int getIdComposite() {
        return idComposite;
    }

    public String getNomComposite() {
        return nomComposite;
    }

    public void setNomComposite(String nomComposite) {
        this.nomComposite = nomComposite;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }
}
