package com.openclassrooms.p6.paymybuddy.dto;

import lombok.Data;

@Data
public class TransactionDto {

    private Long amount;

    private String description;

    private Integer recipientid;
}
