package fr.diginamic.entite;

import javax.persistence.*;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "tableGenerator", initialValue = 1, allocationSize = 1, table = "hibernate_sequences")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero", nullable = false, length = 50, unique = true)
    private String numero;

    @Column(name = "solde", nullable = true)
    private double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
