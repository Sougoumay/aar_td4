package services;

import entities.*;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    /**
     * Renvoie le produit dont l'id est fourni. et null si non trouvé.
     * @param idProduit
     * @return
     */
    public Produit findById(int idProduit) {
        Produit produit = em.find(Produit.class, idProduit);
        Produit produit1 = (Produit) em.createQuery("SELECT p From Produit p where p.id=:idProduit");
        return produit1;
    }

    /**
     * Renvoie le nom du produit correspondant à la plus grosse ligne de vente
     * @return
     */
    public String  nomProduitPlusGrosseLigne(){
        String productName = em.createQuery("Select l.produit.nomProduit from LigneVente l where l.quantite=max(l.quantite)").toString();
        String productName1 = em.createQuery("Select l.produit.nomProduit from LigneVente l order by l.quantite DESC").setMaxResults(1).getSingleResult().toString();
        //String productName2 = em.createQuery("Select l.produit.nomProduit from LigneVente l where l.quantite= (select max(l1.quantite) from LigneVente l1)").toString();
        return productName;
    }

    /**
     * Renvoie le produit dont les ventes sont les plus grandes en nombre d'unité (en quantité)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteQuantite() {

        // On recupère tous les ventes depuis la table ligneVente
        List<LigneVente> ligneVentes = em.createQuery("From LigneVente").getResultList();

        // On associe chaque produit à la somme de sa quantité vendu
        Map<Produit, Integer> productByQuantity = new HashMap<>();
        for (LigneVente ligneVente : ligneVentes) {
            Produit produit = ligneVente.getProduit();
            int quantity = ligneVente.getQuantite();
            productByQuantity.put(produit, productByQuantity.getOrDefault(produit, 0) + quantity);
        }

        // On recupère le produit ayant la plus grande quantité de vente en somme
        Produit produit1 = null;
        int maxQuantity = 0;
        for (Map.Entry<Produit, Integer> entry : productByQuantity.entrySet()) {
           if (entry.getValue() > maxQuantity) {
               maxQuantity = entry.getValue();
               produit1 = entry.getKey();
           }
        }

        return produit1;
    }


    /**
     * Renvoie le produit dont les ventes génèrent le plus gros chiffre d'affaire (quantité * prix unitaire)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteMontant() {
        // On recupère tous les ventes depuis la table ligneVente
        List<LigneVente> ligneVentes = em.createQuery("From LigneVente").getResultList();

        // On associe chaque produit à la somme de sa quantité vendu pour pouvoir calculer le chiffre d'affaire generé par produit
        Map<Produit, Integer> productByQuantity = new HashMap<>();
        for (LigneVente ligneVente : ligneVentes) {
            Produit produit = ligneVente.getProduit();
            int quantity = ligneVente.getQuantite();
            productByQuantity.put(produit, productByQuantity.getOrDefault(produit, 0) + quantity);
        }

        // On recupère le produit ayant generé le prix d'affaire le plus elevé
        Produit produit1 = null;
        float maxChiffreAffaire = 0.0f;
        for(Map.Entry<Produit, Integer> entry : productByQuantity.entrySet()) {
            Produit produit = entry.getKey();
            int quantity = entry.getValue();
            if (quantity*produit.getPrixVente() > maxChiffreAffaire) {
                produit1 = produit;
            }
        }

        return produit1;
    }

    /**
     * Renvoie la liste des produits dont le stock est inférieur ou égal à stockMini
     * @param stockMini
     * @return
     */
    public List<Produit> stockSous(int stockMini) {
        List<Produit> produits = em.createQuery("Select p From Produit p where p.stock<:stockMini").getResultList();
        return produits;
    }

    /**
     * Renvoie la liste des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<Vente> ventesDe(int idProduit) {
        List<Vente> ventes1 = em.createQuery("Select v from Vente v JOIN LigneVente lv JOIN Produit p where p.idProduit=:idProduit").getResultList();
        List<Vente> ventes2 = em.createQuery("Select v from Vente v JOIN LigneVente lv where lv.produit.idProduit=:idProduit").getResultList();
        List<Vente> ventes3 = em.createQuery("select lv.vente from LigneVente lv where lv.produit.idProduit=:idProduit").getResultList();
        return ventes3;
    }

      /**
     * Renvoie la liste ** dates de commande *** des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<LocalDate> datesVentesDe(int idProduit) {
        List<LocalDate> dates = em.createQuery("select lv.vente.dateCmd from LigneVente lv where lv.produit.idProduit=:idProduit").getResultList();
        return dates;
    }

    /**
     * Renvoie la liste des produits qui n'ont jamais été vendus (aucune vente)
     * @return
     */
    public List<Produit> produitsNonVendus() {
        List<Produit> produitsNonVendus = em.createQuery("Select p From Produit p where p not in (select distinct lv.produit from LigneVente lv)").getResultList();
        return produitsNonVendus;
    }

    /**
     * Renvoie les gestionnaires qui ont déjà passé des demandes d'approvisionnement pour le produit en paramètre
     * @param idProduit
     * @return
     */
    public List<Gestionnaire> acheteurDe(int idProduit){
        List<Gestionnaire> gestionnaires = em.createQuery("select lA.approvisionnement.gestionnaire from LigneApprovisionnement lA where lA.produit.idProduit=:idProduit").getResultList();
        return gestionnaires;
    }

    /**
     * Renvoie le produit le moins cher de la catégorie indiquée.
     * @param idCategorie
     * @return
     */
    public Produit moinsCherDe(int idCategorie) {
        // Les deux premières requêtes utilisent trient les produits dans l'ordre ascendant des prix et prend la première, donc celle ayant le prix min
        Produit produit = em.createQuery("select p from Produit p where p.categorie.idCategorie=:idCategorie order by p.prixVente ASC", Produit.class)
                .setParameter("idCategorie", idCategorie)
                .setMaxResults(1) // Limite le résultat à un seul produit
                .getSingleResult();
        Produit produit2 = em.createQuery("select p from Produit p where p.categorie.idCategorie=:idCategorie order by p.prixVente ASC", Produit.class)
                .getSingleResult();

        // Cette requête fais une double requête en faisant un select sur le **min de prix de vente**
        Produit produit1 = (Produit) em.createQuery("select p from Produit p where p.categorie.idCategorie=:idCategorie and p.prixVente=(select min(p1.prixVente) from Produit p1 where p1.categorie.id=:idCategorie)");
        return produit;
    }

    /**
     * Renvoie la catégorie du produit indiqué.
     * @param idProduit
     * @return
     */
    public Categorie categorieDe(int idProduit) {
        Categorie categorie = (Categorie) em.createQuery("select p.categorie from Produit p where p.idProduit:=idProduit");
        return categorie;
    }
}
