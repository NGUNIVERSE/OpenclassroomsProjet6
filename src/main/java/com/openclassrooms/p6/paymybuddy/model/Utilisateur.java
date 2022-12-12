package com.openclassrooms.p6.paymybuddy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
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
    private Long solde = 0L;
    private String role;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> transfers = new ArrayList<>();
    @OneToMany(mappedBy = "recipient")
    private List<Transaction> credits = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "connections",
            joinColumns = @JoinColumn(name = "senderid"),
            inverseJoinColumns = @JoinColumn(name = "recipientid"))
    private Set<Utilisateur> connections = new HashSet<>();


}
