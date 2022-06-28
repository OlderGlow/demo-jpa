package fr.diginamic.TP2TP3.entite;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;
    @Column(name = "delai", nullable = false)
    private Integer delai;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    @JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private Set<Livre> livres;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", delai=" + delai +
                ", dateFin=" + dateFin +
                ", client=" + client +
                '}' + "\n";
    }
}
