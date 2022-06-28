package fr.diginamic.TP2TP3;

import fr.diginamic.TP2TP3.entite.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConnexionJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("livres-emprunt");
        EntityManager em = emf.createEntityManager();
        Emprunt emprunt = em.find(Emprunt.class, 1);
        if(emprunt != null) {
            System.out.println(emprunt.getLivres());
        } else {
            System.out.println("Emprunt non trouvé !");
        }
        List<Emprunt> emprunts = findEmpruntByClientId(1);
        for(Emprunt empruntTmp : emprunts) {
            System.out.println(empruntTmp.getLivres() + "\n");
        }
    }

    public static List<Emprunt> findEmpruntByClientId(int id) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("livres-emprunt");
        EntityManager em = emf.createEntityManager();
        List<Emprunt> emprunts = em.createQuery("select e from Emprunt e where e.client.id = :id", Emprunt.class).setParameter("id", id).getResultList();
        return emprunts;
    }
}
