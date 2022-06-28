package fr.diginamic.TP1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();
        Auteur a = em.find(Auteur.class, 2);
        if(a != null) {
            System.out.println(a.getNom());
        } else {
            System.out.println("Auteur non trouvé");
        }
        // Insérer un nouvel auteur en bdd
            Auteur auteur = new Auteur();
            auteur.setNom("Dupont");
            auteur.setPrenom("Jean");
            em.getTransaction().begin();
            em.persist(auteur);
            em.getTransaction().commit();
        Auteur auteur1 = em.find(Auteur.class, 3);
        if(auteur1 != null) {
            auteur1.setPrenom("caca");
        } else {
            System.out.println("Auteur non trouvé");
        }
        em.getTransaction().begin();
        em.persist(auteur1);
        em.getTransaction().commit();
        System.out.println("\n\n\n");
        System.out.println("Liste des auteurs");
        System.out.println("----------------");
        for(Auteur auteurTmp : em.createQuery("select a from Auteur a", Auteur.class).getResultList()) {
            System.out.println(auteurTmp.getNom() + " " + auteurTmp.getPrenom());
        }
        em.close();
        emf.close();
    }

}
