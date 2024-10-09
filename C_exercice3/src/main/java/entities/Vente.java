package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Vente {
    @Id @GeneratedValue
    private int idVente;
    @Basic
    private LocalDate dateCmd;
    @Basic
    private LocalDate dateLivraison;
    @OneToMany(mappedBy = "vente")
    private List<LigneVente> lignesV;

    public int getIdVente() {
        return idVente;
    }

    public LocalDate getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(LocalDate dateCmd) {
        this.dateCmd = dateCmd;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public List<LigneVente> getLignesV() {
        return lignesV;
    }

    public void setLignesV(List<LigneVente> lignesV) {
        this.lignesV = lignesV;
    }
}
