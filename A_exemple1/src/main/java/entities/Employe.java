package entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Employe {
    @Id @GeneratedValue
    private int idEmp;
    private String prenom;
    private String nom;
    @OneToMany
    private List<Telephone> telephones;
    @OneToOne
    private Machine machine;
    @ManyToOne
    private Service service;
    @OneToOne
    private Adresse adresse;
    @ManyToMany
    private Set<Projet> projetsEnCours;


    public Employe() {}

    /* Ce constructeur comporte des paramètres. On est donc obligé de spécifier un constructeur vide (ci dessus).
     */
    public Employe(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Projet> getProjetsEnCours() {
        return projetsEnCours;
    }

    public void setProjetsEnCours(Set<Projet> projetsEnCours) {
        this.projetsEnCours = projetsEnCours;
    }
}
