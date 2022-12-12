package com.openclassrooms.p6.paymybuddy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "senderid", nullable = false)
    private Utilisateur sender;
    @ManyToOne
    @JoinColumn(name = "recipientid", nullable = false)
    private Utilisateur recipient;

}
