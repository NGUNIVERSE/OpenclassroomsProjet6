package com.openclassrooms.p6.paymybuddy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "connection")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer senderid;
    private Integer recipientid;

}
