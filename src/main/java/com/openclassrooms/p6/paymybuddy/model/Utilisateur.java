package com.openclassrooms.p6.paymybuddy.model;

import lombok.Data;

import javax.persistence.*;

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

}
