package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Approvisionnement {
    @Id @GeneratedValue
    private int idAppro;
    private LocalDate dateCmd;
    private LocalDate dateReception;
    @OneToMany(mappedBy = "approvisionnement")
    private List<LigneApprovisionnement> lignesA;
    @ManyToOne
    Gestionnaire gestionnaire;

    public int getIdAppro() {
        return idAppro;
    }

    public LocalDate getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(LocalDate dateCmd) {
        this.dateCmd = dateCmd;
    }

    public LocalDate getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDate dateReception) {
        this.dateReception = dateReception;
    }

    public List<LigneApprovisionnement> getLignesA() {
        return lignesA;
    }

    public void setLignesA(List<LigneApprovisionnement> lignesA) {
        this.lignesA = lignesA;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }
}
