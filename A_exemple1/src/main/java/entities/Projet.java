package entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Projet {
    @Id
    private String codeProjet;
    private String nomProjet;
    @Enumerated(EnumType.STRING)
    private StatutProjet statut;
    @ManyToMany(mappedBy = "projetsEnCours")
    private Set<Employe> participants;
    /* l'attribut ci-dessous est un peu tiré par les cheveux... c'est pour l'exemple...*/
    @ManyToMany
    private Set<Employe> participantsProjetTermine;

    public Projet(){}

    /* Ce constructeur comporte des paramètres. On est donc obligé de spécifier un constructeur vide (ci dessus).
     */
    public Projet(String codeProjet, String nomProjet) {
        this.codeProjet = codeProjet;
        this.nomProjet = nomProjet;
    }

    public String getCodeProjet() {
        return codeProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public StatutProjet getStatut() {
        return statut;
    }

    public void setStatut(StatutProjet statut) {
        this.statut = statut;
    }

    public Set<Employe> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Employe> participants) {
        this.participants = participants;
    }

    public Set<Employe> getParticipantsProjetTermine() {
        return participantsProjetTermine;
    }

    public void setParticipantsProjetTermine(Set<Employe> participantsProjetTermine) {
        this.participantsProjetTermine = participantsProjetTermine;
    }
}
