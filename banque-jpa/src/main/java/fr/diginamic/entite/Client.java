package fr.diginamic.entite;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;

    @Column(name = "date_naissance", columnDefinition = "TIMESTAMP")
    private LocalDate dateDeNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    private Banque banque;

    @ManyToMany
    @JoinTable(name="compte_client",
            joinColumns= @JoinColumn(name="comptes_id", referencedColumnName="ID"), inverseJoinColumns= @JoinColumn(name="clients_id", referencedColumnName="ID")
    )
    private Set<Compte> comptes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}
