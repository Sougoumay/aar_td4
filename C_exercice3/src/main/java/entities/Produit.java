package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Produit {
    @Id @GeneratedValue
    private int idProduit;
    private String nomProduit;
    private int stock;
    private float prixVente;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private List<LigneApprovisionnement> appros;
    @OneToMany(mappedBy = "produit")
    private List<LigneVente> ventes;

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneApprovisionnement> getAppros() {
        return appros;
    }

    public void setAppros(List<LigneApprovisionnement> appros) {
        this.appros = appros;
    }

    public List<LigneVente> getVentes() {
        return ventes;
    }

    public void setVentes(List<LigneVente> ventes) {
        this.ventes = ventes;
    }
}
