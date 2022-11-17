package com.openclassrooms.p6.paymybuddy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String motdepasse;
    private Long solde;
    private String role;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> transfers;
    @OneToMany(mappedBy = "recipient")
    private List<Transaction> credits;


    @ManyToMany
    @JoinTable(
            name = "connections",
            joinColumns = @JoinColumn(name = "senderid"),
            inverseJoinColumns = @JoinColumn(name = "recipientid"))
    private Set<Utilisateur> connections;


}
