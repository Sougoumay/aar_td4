package entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@NamedQueries(
        {
                @NamedQuery(
                        name = "entities.Employe.projetAvec",
                        query = "Select e2 From Employe e1 Join e1.projetsEnCours p Join p.participants e2 where e1.idEmp=:id and e2.idEmp<>:id")
                ,
                @NamedQuery(
                        name = "entities.Employe.sansProjet",
                        query = "SELECT e FROM Employe e WHERE e NOT IN (SELECT e2 FROM Projet p join p.participants e2)"
                ),
                @NamedQuery(
                        name = "entities.Employe.sansProjetDto",
                        query = "SELECT new dtos.EmployeDTO(e.nom,e.prenom) FROM Employe e WHERE e NOT IN (SELECT e2 FROM Projet p join p.participants e2)"
                )
        }
)


@NamedNativeQuery(
        name = "entities.Employe.sansProjetNative",
        query = "SELECT * FROM EMPLOYES WHERE IDEMP NOT IN (SELECT IDEMP FROM PROJETSENCOURS)",
        resultClass = Employe.class
)

@Entity
@Table(name = "EMPLOYES")
public class Employe {
    @Id @GeneratedValue
    @Column(name = "IDEMP")
    private int idEmp;
    @Column(name = "PRENOMEMP",nullable = false)
    private String prenom;
    @Column(name = "NOMEMP",nullable = false)
    private String nom;
    @OneToMany
    @JoinTable(name = "TELEPHONEDE",joinColumns = {@JoinColumn(name="IDEMP")},inverseJoinColumns = {@JoinColumn(name = "IDTEL")})
    private List<Telephone> telephones;
    @OneToOne
    @JoinColumn(name="IDMACHINE")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="IDSERVICE")
    private Service service;
    @OneToOne
    @JoinColumn(name = "IDADRESSE")
    private Adresse adresse;
    @ManyToMany
    @JoinTable(name = "PROJETSENCOURS",joinColumns = {@JoinColumn(name = "IDEMP")},inverseJoinColumns = {@JoinColumn(name = "CODEPROJET")})
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
