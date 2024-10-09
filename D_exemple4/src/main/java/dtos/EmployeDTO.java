package dtos;

public class EmployeDTO {
    private String nom;
    private String prenom;


    public EmployeDTO(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
