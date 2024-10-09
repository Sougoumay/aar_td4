package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class Groupe {

    @Id
    private String idGroup;

    private String intitule;

    @ManyToMany(mappedBy = "groupes")
    private Set<Formation> etudiantsDe;

    @ManyToMany
    private Set<Etudiant> membres;

    @ManyToMany
    private Set<Creneau> creneaux;
}
