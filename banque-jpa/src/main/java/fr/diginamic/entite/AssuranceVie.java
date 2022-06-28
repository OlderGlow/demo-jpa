package fr.diginamic.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {
    @Column(name = "date_fin", columnDefinition = "TIMESTAMP")
    private LocalDate dateFin;

    @Column(name = "taux", nullable = false)
    private double taux;

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
