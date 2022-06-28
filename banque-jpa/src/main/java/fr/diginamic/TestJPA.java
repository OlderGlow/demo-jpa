package fr.diginamic;

import fr.diginamic.entite.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-db");
        EntityManager em = emf.createEntityManager();
        Set<Compte> c = new HashSet<>();

        em.getTransaction().begin();

        Adresse adresse = new Adresse();
        adresse.setNumero(4);
        adresse.setRue("Rue de la madeleine");
        adresse.setVille("Angers");
        adresse.setCodePostal(49100);

        Banque banque = new Banque();
        banque.setNom("La banque du futur");

        Banque banque1 = new Banque();
        banque1.setNom("Aile, c'est aile");

        Client pierre = new Client();
        pierre.setAdresse(adresse);
        pierre.setDateDeNaissance(LocalDate.of(1996, 10, 01));
        pierre.setPrenom("Pierre");
        pierre.setNom("Tremblay");
        pierre.setBanque(banque);

        Client adrien = new Client();
        adrien.setAdresse(adresse);
        adrien.setDateDeNaissance(LocalDate.of(1993, 9, 13));
        adrien.setPrenom("Adrien");
        adrien.setNom("Pinheiro");
        adrien.setBanque(banque1);

        Compte compte1 = new Compte();
        compte1.setSolde(500);
        compte1.setNumero("8901729J1872");

        Compte compte2 = new Compte();
        compte2.setSolde(1000);
        compte2.setNumero("KS29J1872");

        LivretA compte = new LivretA();
        compte.setNumero("19K7372");
        compte.setSolde(100000);
        compte.setTaux(10);

        AssuranceVie compte3 = new AssuranceVie();
        compte3.setNumero("19K7379982");
        compte3.setSolde(100000);
        compte3.setTaux(3);
        compte3.setDateFin(LocalDate.now().plusYears(4));

        Operation operation = new Operation();
        operation.setMontant(100);
        operation.setDate(LocalDate.now());
        operation.setMotif("Depot");
        operation.setCompte(compte1);

        Virement virement = new Virement();
        virement.setMontant(1200);
        virement.setDate(LocalDate.now());
        virement.setMotif("Depot");
        virement.setCompte(compte1);
        virement.setBeneficiaire("Pierre Tremblay");

        Set<Compte> comptesAdrien = new HashSet<>();
        comptesAdrien.add(compte1);
        comptesAdrien.add(compte2);
        comptesAdrien.add(compte3);
        adrien.setComptes(comptesAdrien);

        c.add(compte1);
        c.add(compte2);
        c.add(compte);
        pierre.setComptes(c);

        em.persist(banque);
        em.persist(banque1);
        em.persist(compte);
        em.persist(compte1);
        em.persist(compte2);
        em.persist(compte3);
        em.persist(pierre);
        em.persist(adrien);
        em.persist(operation);
        em.persist(virement);
        em.getTransaction().commit();
    }
}
