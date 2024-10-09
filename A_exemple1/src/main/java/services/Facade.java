package services;

import entities.Employe;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Collection;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createEmploye(String prenom, String nom) {
        Employe emp=new Employe(prenom,nom);
        em.persist(emp);
    }

    public Collection<Employe> findAllEmploye() {
        return em.createQuery("From Employe e").getResultList();
    }


}
