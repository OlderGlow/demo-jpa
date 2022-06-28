package fr.diginamic.entite;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "operationGenerator", initialValue = 1, allocationSize = 1, table = "hibernate_sequences")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private LocalDate date;

    @Column(name = "montant", nullable = false)
    private double montant;

    @Column(name = "libelle", length = 50)
    private String motif;

    @ManyToOne
    private Compte compte;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
