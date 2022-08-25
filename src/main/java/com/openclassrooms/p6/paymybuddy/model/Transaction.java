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

    private String descriptions;
    private Long amount;
    private int senderid;
    private int recipientid;

}
