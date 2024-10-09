package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Gestionnaire {
    @Id
    private String idGest;
    private String prenomGest;
    private String nomGest;

    public String getIdGest() {
        return idGest;
    }

    public String getPrenomGest() {
        return prenomGest;
    }

    public void setPrenomGest(String prenomGest) {
        this.prenomGest = prenomGest;
    }

    public String getNomGest() {
        return nomGest;
    }

    public void setNomGest(String nomGest) {
        this.nomGest = nomGest;
    }
}
