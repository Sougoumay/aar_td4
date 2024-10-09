package services;

import entities.Composant;
import entities.Composite;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void deleteComposite(int idComposite) {
        Composite composite=em.find(Composite.class,idComposite);
        em.remove(composite);

        //em.createQuery("delete from Composite c where c.idComposite= :id").setParameter("id",idComposite).executeUpdate();

    }

    @Transactional
    public void dereferenceComposant(int idComposant) {
        Composant composant=em.find(Composant.class,idComposant);
        Composite composite=composant.getComposite();
        composite.getComposants().remove(composant);
        //composant.setComposite(null);
    }

    @Transactional
    public void createComposant(String nomComposant, int idComposite,boolean ajoutDansComposite){
        Composant composant=new Composant();
        composant.setNomComposant(nomComposant);
        em.persist(composant);

        Composite composite=em.find(Composite.class,idComposite);

        if (ajoutDansComposite==true){
            composite.getComposants().add(composant);
        } else {
            composant.setComposite(composite);
        }
    }


    public List<Composite> findAllComposites() {
        return em.createQuery("Select c From Composite c").getResultList();
    }

    public List<Composite> findAllComposants() {
        return em.createQuery("Select c From Composant c").getResultList();
    }

}
