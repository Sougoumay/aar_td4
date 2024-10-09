package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneApprovisionnement {
    @Id @GeneratedValue
    private int idLA;
    @ManyToOne
    private Approvisionnement approvisionnement;
    @ManyToOne
    private Produit produit;
    private int quantite;

    public int getIdLA() {
        return idLA;
    }

    public Approvisionnement getApprovisionnement() {
        return approvisionnement;
    }

    public void setApprovisionnement(Approvisionnement approvisionnement) {
        this.approvisionnement = approvisionnement;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
