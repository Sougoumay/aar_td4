package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@NamedQuery(
    name="entities.Telephone.nonAffectes",
    query="Select t From Telephone t where t not in (select t2 From Employe e Join e.telephones t2)"
    )

@Entity
public class Telephone {
    @Id @GeneratedValue
    private int idTel;
    private String numero;
    private String modele;

    public Telephone(){}

    /* Ce constructeur comporte des paramètres. On est donc obligé de spécifier un constructeur vide (ci dessus).
     */
    public Telephone(String modele) {
        this.modele = modele;
    }

    public int getIdTel() {
        return idTel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}
